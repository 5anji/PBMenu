package com.menius.tablo.controller;

import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
import com.menius.tablo.entities.response.RestaurantsGetResponseDto;
import com.menius.tablo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/tablo/restaurant")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/get-all-restaurants")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<RestaurantsGetResponseDto> getAllRestaurants(@RequestBody GetNumberOfPage getNumberOfPage) {
        return restaurantService.getAllRestaurants(getNumberOfPage);
    }

    @PostMapping("/save-restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRestaurant(@RequestBody RestaurantsGetRequestDto restaurantsGetRequestDto) {
        restaurantService.saveRestaurant(restaurantsGetRequestDto);
    }

    @DeleteMapping("/delete-restaurant")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRestaurant(@RequestParam UUID restaurantId) {
        restaurantService.deleteRestaurantById(restaurantId);
    }

    @GetMapping("/get-restaurant-by-id")
    @ResponseStatus(HttpStatus.FOUND)
    public RestaurantsGetResponseDto getRestaurant(@RequestParam UUID restaurantId){
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PutMapping("/detach-restaurant")
    @ResponseStatus(HttpStatus.OK)
    public void detachRestaurant(@RequestParam UUID restaurantId){
        restaurantService.detach(restaurantId);
    }
}
