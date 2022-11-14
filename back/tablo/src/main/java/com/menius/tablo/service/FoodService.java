package com.menius.tablo.service;

import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.response.FoodResponseDto;

import java.util.List;
import java.util.UUID;

public interface FoodService {
    void saveFood(FoodRequestDto foodRequestDto);
    List<FoodResponseDto> getAllFood(GetNumberOfPage getNumberOfPage);
    FoodResponseDto getFoodById(UUID foodId);
    void deleteFood(UUID foodId);
    List<FoodResponseDto> getSpicyFood(GetNumberOfPage getNumberOfPage);
    List<FoodResponseDto> getVegetarianFood(GetNumberOfPage getNumberOfPage);
    List<FoodResponseDto> getFoodByRestaurants(UUID restaurantId, GetNumberOfPage getNumberOfPage);
    void detach(UUID foodId);
}
