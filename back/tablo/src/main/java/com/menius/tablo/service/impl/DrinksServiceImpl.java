package com.menius.tablo.service.impl;

import com.menius.tablo.entities.dbo.DrinksDbo;
import com.menius.tablo.entities.dbo.RestaurantDbo;
import com.menius.tablo.entities.enms.Status;
import com.menius.tablo.entities.requests.DrinkRequestDto;
import com.menius.tablo.entities.response.DrinkGetResponseDto;
import com.menius.tablo.repository.DrinksRepository;
import com.menius.tablo.repository.RestaurantRepository;
import com.menius.tablo.service.DrinksService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.menius.tablo.entities.enms.Status.DETACHED;
import static java.util.stream.Collectors.toList;


@RequiredArgsConstructor
@Service
public class DrinksServiceImpl implements DrinksService {
    private final DrinksRepository drinkRepository;
    private final RestaurantRepository restaurantRepository;


    @Override
    public void saveDrink(DrinkRequestDto requestDto) {
        drinkRepository.save(DrinksDbo.builder()
                .drinkName(requestDto.getDrinkName())
                .drinkIngredients(requestDto.getDrinkIngredients())
                .isAlcoholic(requestDto.isAlcoholic())
                .restaurantDbo(restaurantRepository.getByRestaurantId(requestDto.getRestaurantId()).orElseThrow())
                .drinkPrice(requestDto.getDrinkPrice())
                .isDeliverable(requestDto.isDeliverable())
                .status(requestDto.getStatus())
                .drinkPhoto(requestDto.getDrinkPhoto())
                .build());
    }

    @Override
    public void deleteDrink(UUID uuid){
        drinkRepository.deleteById(uuid);
    }

    @Override
    public void detachDrinkFromMenu(UUID uuid) {
        drinkRepository.findById(uuid).orElseThrow().setStatus(DETACHED);
    }

    @Override
    public DrinkGetResponseDto getDrinkById(UUID uuid) {
        return convertToDto(drinkRepository.findById(uuid).orElseThrow());
    }

    @Override
    public List<DrinkGetResponseDto> getDrinkByRestaurant(UUID restaurantId, int pages, int nrOfItems) {
        RestaurantDbo restaurantDbo = restaurantRepository.findById(restaurantId).orElseThrow();
        return drinkRepository.getDrinksDboByRestaurantDbo(restaurantDbo, PageRequest.of(pages, nrOfItems)).stream()
                .filter(drinksDbo -> drinksDbo.getStatus().equals(Status.AVAILABLE))
                .map(this::convertToDto)
                .collect(toList());
    }

//    @Override
//    public List<DrinkGetResponseDto> getAllDrinksByRestaurant(GetDrinksByRestaurantDto request) {
//        RestaurantDbo restaurantDbo = restaurantRepository.findById(request.getRestaurant())
//                .orElseThrow();
//        List<DrinksDbo> drinksDboByRestaurantDbo;
//        if (request.getIsAlcoholic() != null) {
//            drinksDboByRestaurantDbo = drinkRepository.getDrinksDboByAlcoholicIsAndRestaurantDbo(
//                    restaurantDbo,
//                    request.getIsAlcoholic(),
//                    (Pageable) PageRequest.of(request.getPage(), request.getSize())
//            );
//        } else {
//            drinksDboByRestaurantDbo = drinkRepository.getDrinksDboByRestaurantDbo(restaurantDbo,
//                    (Pageable) PageRequest.of(request.getPage(), request.getSize()));
//        }
//
//        return drinksDboByRestaurantDbo.stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<DrinkGetResponseDto> getAllDrinksByAlcohol(GetDrinksByParametersDto request) {
//        RestaurantDbo restaurantDbo = restaurantRepository.findById(request.getRestaurant())
//                .orElseThrow();
//        List<DrinksDbo> drinksByAlcoholAndRestaurant =
//                drinkRepository.getDrinksDboByAlcoholicIsAndRestaurantDbo(restaurantDbo, request.isAlcoholic(),
//                (Pageable) PageRequest.of(request.getPage(), request.getSize()));
//       return drinksByAlcoholAndRestaurant.stream()
//               .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }


    private DrinkGetResponseDto convertToDto(DrinksDbo drinksDbo) {
        return DrinkGetResponseDto.builder()
                .drinkName(drinksDbo.getDrinkName())
                .drinkIngredients(drinksDbo.getDrinkIngredients())
                .isAlcoholic(drinksDbo.isAlcoholic())
                .restaurantId(drinksDbo.getRestaurantDbo().getRestaurantId())
                .drinkPrice(drinksDbo.getDrinkPrice())
                .isDeliverable(drinksDbo.isDeliverable())
                .status(drinksDbo.getStatus())
                .drinkPhoto(drinksDbo.getDrinkPhoto())
                .build();
    }
}
