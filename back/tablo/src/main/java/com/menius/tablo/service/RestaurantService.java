package com.menius.tablo.service;

import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
import com.menius.tablo.entities.response.RestaurantsGetResponseDto;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {
    List<RestaurantsGetResponseDto> getAllRestaurants(GetNumberOfPage getNumberOfPage);
    RestaurantsGetResponseDto getRestaurantById(UUID restaurantId);
    void deleteRestaurantById(UUID restaurantId);
    void detach (UUID restaurantId);
    void saveRestaurant(RestaurantsGetRequestDto restaurantsGetRequestDto);
}
