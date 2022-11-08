package com.menius.tablo.controller;

import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.response.FoodResponseDto;
import com.menius.tablo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/tablo/food")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FoodController {

    private final FoodService foodService;
    @GetMapping("/get-all-food")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<FoodResponseDto> getAllFood(@RequestBody GetNumberOfPage getNumberOfPage) {
        return foodService.getAllFood(getNumberOfPage);
    }

    @PostMapping("/save-food")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFood(@RequestBody FoodRequestDto foodRequestDto) {
        foodService.saveFood(foodRequestDto);
    }

    @DeleteMapping("/delete-food")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFoodById(@RequestParam UUID foodId) {
        foodService.deleteFood(foodId);
    }

    @GetMapping("/get-food-by-id")
    @ResponseStatus(HttpStatus.FOUND)
    public FoodResponseDto getFoodById(@RequestParam UUID foodId){
        return foodService.getFoodById(foodId);
    }

    @GetMapping("/get-food-by-restaurant")
    @ResponseStatus(HttpStatus.FOUND)
    public List<FoodResponseDto> getFoodByRestaurant(@RequestParam UUID restaurantId, @RequestParam GetNumberOfPage getNumberOfPage){
        return foodService.getFoodByRestaurants(restaurantId, getNumberOfPage);
    }

    @PutMapping("/detach-food")
    @ResponseStatus(HttpStatus.OK)
    public void detachFood(@RequestParam UUID foodId){
        foodService.detach(foodId);
    }

}
