package com.menius.tablo.service;

import com.menius.tablo.entities.requests.FoodRequestDto;

public interface FoodService {
    void saveFood(FoodRequestDto foodRequestDto);
}
