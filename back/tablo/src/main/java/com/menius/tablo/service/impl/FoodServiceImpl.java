package com.menius.tablo.service.impl;

import com.menius.tablo.entities.FoodDbo;
import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.response.FoodResponseDto;
import com.menius.tablo.repository.FoodRepository;
import com.menius.tablo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;

    @Override
    public void saveFood(FoodRequestDto foodRequestDto){
        foodRepository.save(FoodDbo.builder()
                        .foodId(foodRequestDto.getFoodId())
                        .foodStatus(foodRequestDto.getFoodStatus())
                        .foodIngredients(foodRequestDto.getFoodIngredients())
                        .foodName(foodRequestDto.getFoodName())
                        .foodPhoto(foodRequestDto.getFoodPhoto())
                        .restaurantDbo(foodRequestDto.getRestaurantDbo())
                .build());
    }

    public List<FoodResponseDto> getAllFood(GetNumberOfPage getNumberOfPage){
        return foodRepository.findAll(PageRequest.of(getNumberOfPage.getPages(), getNumberOfPage.getNrOfItems())).stream()
                .map(f -> FoodResponseDto.builder()
                        .foodIngredients(f.getFoodIngredients())
                        .foodStatus(f.getFoodStatus())
                        .foodPhoto(f.getFoodPhoto())
                        .foodName(f.getFoodName())
                        .foodId(f.getFoodId())
                        .restaurantDbo(f.getRestaurantDbo())
                                .build())
                .collect(Collectors.toList());
    }

    public FoodResponseDto getFoodById(UUID foodId){
        FoodDbo foodDbo = foodRepository.findFoodDboByFoodId(foodId).orElseThrow();
        return FoodResponseDto.builder()
                .restaurantDbo(foodDbo.getRestaurantDbo())
                .foodId(foodDbo.getFoodId())
                .foodIngredients(foodDbo.getFoodIngredients())
                .foodName(foodDbo.getFoodName())
                .foodPhoto(foodDbo.getFoodPhoto())
                .foodStatus(foodDbo.getFoodStatus())
                .build();
    }

    public void deleteFood(UUID foodId){
        foodRepository.deleteById(foodId);
    }
}
