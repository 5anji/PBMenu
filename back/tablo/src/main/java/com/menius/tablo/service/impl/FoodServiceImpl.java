package com.menius.tablo.service.impl;

import com.menius.tablo.entities.FoodDbo;
import com.menius.tablo.entities.RestaurantDbo;
import com.menius.tablo.entities.enms.FoodStatus;
import com.menius.tablo.entities.enms.RestaurantStatus;
import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.response.FoodResponseDto;
import com.menius.tablo.repository.FoodRepository;
import com.menius.tablo.repository.RestaurantRepository;
import com.menius.tablo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.menius.tablo.entities.enms.FoodStatus.AVAILABLE;
import static com.menius.tablo.entities.enms.FoodStatus.DETACHED;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void saveFood(FoodRequestDto foodRequestDto) {
        foodRepository.save(FoodDbo.builder()
                .foodStatus(foodRequestDto.getFoodStatus())
                .foodIngredients(foodRequestDto.getFoodIngredients())
                .foodName(foodRequestDto.getFoodName())
                .foodPhoto(foodRequestDto.getFoodPhoto())
                .restaurantDbo(foodRequestDto.getRestaurantDbo())
                .isSpicy(foodRequestDto.isSpicy())
                .isVegetarian(foodRequestDto.isVegetarian())
                .build());
    }

    @Override
    public List<FoodResponseDto> getAllFood(GetNumberOfPage getNumberOfPage) {
        return foodRepository.findAll(PageRequest.of(getNumberOfPage.getPages(), getNumberOfPage.getNrOfItems())).stream()
                .filter(isAvailable())
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public FoodResponseDto getFoodById(UUID foodId) {
        FoodDbo foodDbo = foodRepository.findFoodDboByFoodId(foodId).orElseThrow();
        return FoodResponseDto.builder()
                .restaurantDbo(foodDbo.getRestaurantDbo())
                .foodId(foodDbo.getFoodId())
                .foodIngredients(foodDbo.getFoodIngredients())
                .foodName(foodDbo.getFoodName())
                .foodPhoto(foodDbo.getFoodPhoto())
                .foodStatus(foodDbo.getFoodStatus())
                .isVegetarian(foodDbo.isVegetarian())
                .isSpicy(foodDbo.isSpicy())
                .build();
    }

    @Override
    public void deleteFood(UUID foodId) {
        foodRepository.deleteById(foodId);
    }

    @Override
    public List<FoodResponseDto> getSpicyFood(GetNumberOfPage getNumberOfPage) {
        return foodRepository.findAll(PageRequest.of(getNumberOfPage.getPages(), getNumberOfPage.getNrOfItems()))
                .stream()
                .filter(isAvailable())
                .filter(FoodDbo::isSpicy)
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public List<FoodResponseDto> getVegetarianFood(GetNumberOfPage getNumberOfPage) {
        return foodRepository.findAll(PageRequest.of(getNumberOfPage.getPages(), getNumberOfPage.getNrOfItems()))
                .stream()
                .filter(isAvailable())
                .filter(FoodDbo::isVegetarian)
                .map(DboToDto())
                .collect(toList());
    }

    @Override
    public List<FoodResponseDto> getFoodByRestaurants(UUID restaurantId, GetNumberOfPage getNumberOfPage) {
        RestaurantDbo restaurantDbo = restaurantRepository.findById(restaurantId).orElseThrow();
        return foodRepository.findFoodDboByRestaurantDbo(restaurantDbo, PageRequest.of(getNumberOfPage.getPages(), getNumberOfPage.getNrOfItems()))
                .stream()
                .filter(isAvailable())
                .map(getFoodDboFoodResponseDtoFunction())
                .collect(toList());
    }

    @Override
    public void detach(UUID foodId) {
        foodRepository.findById(foodId).ifPresent(f -> f.setFoodStatus(DETACHED));
    }

    private static Function<FoodDbo, FoodResponseDto> getFoodDboFoodResponseDtoFunction() {
        return foodDbo -> FoodResponseDto.builder()
                .isSpicy(foodDbo.isSpicy())
                .foodStatus(foodDbo.getFoodStatus())
                .foodPhoto(foodDbo.getFoodPhoto())
                .foodName(foodDbo.getFoodName())
                .foodIngredients(foodDbo.getFoodIngredients())
                .foodId(foodDbo.getFoodId())
                .isVegetarian(foodDbo.isVegetarian())
                .restaurantDbo(foodDbo.getRestaurantDbo())
                .build();
    }

    private static Function<FoodDbo, FoodResponseDto> DboToDto() {
        return foodDbo -> FoodResponseDto.builder()
                .isSpicy(foodDbo.isSpicy())
                .foodStatus(foodDbo.getFoodStatus())
                .foodPhoto(foodDbo.getFoodPhoto())
                .foodName(foodDbo.getFoodName())
                .foodIngredients(foodDbo.getFoodIngredients())
                .foodId(foodDbo.getFoodId())
                .isVegetarian(foodDbo.isVegetarian())
                .restaurantDbo(foodDbo.getRestaurantDbo())
                .build();
    }

    private static Predicate<FoodDbo> isAvailable() {
        return foodDbo -> foodDbo.getFoodStatus().toString().equals(FoodStatus.AVAILABLE.toString());
    }
}
