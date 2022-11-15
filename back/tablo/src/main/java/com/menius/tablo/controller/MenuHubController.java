package com.menius.tablo.controller;

import com.menius.tablo.entities.requests.DrinkRequestDto;
import com.menius.tablo.entities.requests.FoodRequestDto;
import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
import com.menius.tablo.entities.requests.SubsidiaryAddRequestDto;
import com.menius.tablo.entities.response.DrinkGetResponseDto;
import com.menius.tablo.entities.response.FoodResponseDto;
import com.menius.tablo.entities.response.RestaurantsGetResponseDto;
import com.menius.tablo.entities.response.SubsidiaryGetResponseDto;
import com.menius.tablo.service.DrinksService;
import com.menius.tablo.service.FoodService;
import com.menius.tablo.service.RestaurantService;
import com.menius.tablo.service.SubsidiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MenuHubController {
    private final RestaurantService restaurantService;
    private final FoodService foodService;
    private final SubsidiaryService subsidiaryService;
    private final DrinksService drinksService;

    // restaurant endpoints
    @GetMapping("/restaurant")
    @ResponseStatus(OK)
    public List<RestaurantsGetResponseDto> getAllRestaurants(@RequestParam int pages, @RequestParam int nrOfItems) {
        return restaurantService.getAllRestaurants(pages, nrOfItems);
    }

    @PostMapping("/restaurant")
    @ResponseStatus(OK)
    public void saveRestaurant(@RequestBody RestaurantsGetRequestDto restaurantsGetRequestDto) {
        restaurantService.saveRestaurant(restaurantsGetRequestDto);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    @ResponseStatus(OK)
    public void deleteRestaurant(@PathVariable UUID restaurantId) {
        restaurantService.deleteRestaurantById(restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}")
    @ResponseStatus(OK)
    public RestaurantsGetResponseDto getRestaurant(@PathVariable UUID restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PutMapping("/restaurant/{restaurantId}")
    @ResponseStatus(OK)
    public void detachRestaurant(@PathVariable UUID restaurantId) {
        restaurantService.detach(restaurantId);
    }
    // restaurant endpoints end

    //food endpoints
    @GetMapping("/food")
    @ResponseStatus(OK)
    public List<FoodResponseDto> getAllFood(@RequestParam int pages, @RequestParam int nrOfItems) {
        return foodService.getAllFood(pages, nrOfItems);
    }

    @PostMapping("/food")
    @ResponseStatus(OK)
    public void saveFood(@RequestBody FoodRequestDto foodRequestDto) {
        foodService.saveFood(foodRequestDto);
    }

    @DeleteMapping("/food/{foodId}")
    @ResponseStatus(OK)
    public void deleteFoodById(@PathVariable UUID foodId) {
        foodService.deleteFood(foodId);
    }

    @GetMapping("/food/{foodId}")
    @ResponseStatus(OK)
    public FoodResponseDto getFoodById(@PathVariable UUID foodId) {
        return foodService.getFoodById(foodId);
    }

    @GetMapping("/restaurant/{restaurantId}/food")
    @ResponseStatus(OK)
    public List<FoodResponseDto> getFoodByRestaurant(@PathVariable UUID restaurantId, @RequestParam int pages, @RequestParam int nrOfItems) {
        return foodService.getFoodByRestaurant(restaurantId, pages, nrOfItems);
    }

    @PutMapping("/food/{foodId}")
    @ResponseStatus(OK)
    public void detachFood(@PathVariable UUID foodId) {
        foodService.detach(foodId);
    }
    //food endpoints end

    //subsidiary endpoints
    @PostMapping("/subsidiary")
    @ResponseStatus(OK)
    public void addSubsidiary(@RequestBody SubsidiaryAddRequestDto subsidiaryAddRequestDto) {
        subsidiaryService.addSubsidiary(subsidiaryAddRequestDto);
    }

    @PutMapping("/subsidiary/{subsidiaryId}")
    @ResponseStatus(OK)
    public void detachSubsidiary(@PathVariable UUID subsidiaryId) {
        subsidiaryService.detachSubsidiary(subsidiaryId);
    }

    @GetMapping("/subsidiary/{subsidiaryId}")
    @ResponseStatus(OK)
    public SubsidiaryGetResponseDto getSubsidiaryById(@PathVariable UUID subsidiaryId) {
        return subsidiaryService.getSubsidiaryById(subsidiaryId);
    }

    @GetMapping("/restaurant/{restaurantId}/subsidiary")
    @ResponseStatus(OK)
    public List<SubsidiaryGetResponseDto> getSubsidiaryByRestaurantId(@PathVariable UUID restaurantId, @RequestParam int pages, @RequestParam int nrOfItems) {
        return subsidiaryService.getSubsidiaryByRestaurantId(restaurantId, pages, nrOfItems);
    }
    //subsidiary endpoints end

    //drink endpoints
    @PostMapping("/drink")
    @ResponseStatus(OK)
    public void saveDrink(@RequestBody DrinkRequestDto drinkRequestDto) {
        drinksService.saveDrink(drinkRequestDto);
    }

    @DeleteMapping("/drink/{drinkId}")
    @ResponseStatus(OK)
    public void deleteDrinkById(@PathVariable UUID drinkId) {
        drinksService.deleteDrink(drinkId);
    }

    @GetMapping("/drink/{drinkId}")
    @ResponseStatus(OK)
    public DrinkGetResponseDto getDrinkById(@PathVariable UUID drinkId) {
        return drinksService.getDrinkById(drinkId);
    }

    @GetMapping("/restaurant/{restaurantId}/drink")
    @ResponseStatus(OK)
    public List<DrinkGetResponseDto> getDrinkByRestaurant(@PathVariable UUID restaurantId, @RequestParam int pages, @RequestParam int nrOfItems) {
        return drinksService.getDrinkByRestaurant(restaurantId, pages, nrOfItems);
    }

    @PutMapping("/drink/{drinkId}")
    @ResponseStatus(OK)
    public void detachDrink(@PathVariable UUID drinkId) {
        drinksService.detachDrinkFromMenu(drinkId);
    }
    //drink endpoints end
}
