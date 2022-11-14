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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/menu")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MenuHubController {
    private final RestaurantService restaurantService;
    private final FoodService foodService;
    private final SubsidiaryService subsidiaryService;
    private final DrinksService drinksService;

    // restaurant endpoints
    @GetMapping("/restaurant/get-all/{pages}/{nrOfItems}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<RestaurantsGetResponseDto> getAllRestaurants(@PathVariable int pages, @PathVariable int nrOfItems) {
        return restaurantService.getAllRestaurants(pages, nrOfItems);
    }

    @PostMapping("/restaurant/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRestaurant(@RequestBody RestaurantsGetRequestDto restaurantsGetRequestDto) {
        restaurantService.saveRestaurant(restaurantsGetRequestDto);
    }

    @DeleteMapping("/restaurant/delete/{restaurantId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRestaurant(@PathVariable UUID restaurantId) {
        restaurantService.deleteRestaurantById(restaurantId);
    }

    @GetMapping("/restaurant/get-by-id/{restaurantId}")
    @ResponseStatus(HttpStatus.FOUND)
    public RestaurantsGetResponseDto getRestaurant(@PathVariable UUID restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PutMapping("/restaurant/detach/{restaurantId}")
    @ResponseStatus(HttpStatus.OK)
    public void detachRestaurant(@PathVariable UUID restaurantId) {
        restaurantService.detach(restaurantId);
    }
    // restaurant endpoints end

    //food endpoints
    @GetMapping("/food/get-all/{pages}/{nrOfItems}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<FoodResponseDto> getAllFood(@PathVariable int pages, @PathVariable int nrOfItems) {
        return foodService.getAllFood(pages, nrOfItems);
    }

    @PostMapping("/food/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFood(@RequestBody FoodRequestDto foodRequestDto) {
        foodService.saveFood(foodRequestDto);
    }

    @DeleteMapping("/food/delete/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFoodById(@PathVariable UUID foodId) {
        foodService.deleteFood(foodId);
    }

    @GetMapping("/food/get-by-id/{foodId}")
    @ResponseStatus(HttpStatus.FOUND)
    public FoodResponseDto getFoodById(@PathVariable UUID foodId) {
        return foodService.getFoodById(foodId);
    }

    @GetMapping("/food/get-by-restaurantId/{restaurantId}/{pages}/{nrOfItems}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<FoodResponseDto> getFoodByRestaurant(@PathVariable UUID restaurantId, @PathVariable int pages, @PathVariable int nrOfItems) {
        return foodService.getFoodByRestaurant(restaurantId, pages, nrOfItems);
    }

    @PutMapping("/food/detach/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public void detachFood(@PathVariable UUID foodId) {
        foodService.detach(foodId);
    }
    //food endpoints end

    //subsidiary endpoints
    @PostMapping("/subsidiary/save")
    @ResponseStatus(CREATED)
    public void addSubsidiary(@RequestBody SubsidiaryAddRequestDto subsidiaryAddRequestDto) {
        subsidiaryService.addSubsidiary(subsidiaryAddRequestDto);
    }

    @PutMapping("/subsidiary/detach/{subsidiaryId}")
    @ResponseStatus(ACCEPTED)
    public void detachSubsidiary(@PathVariable UUID subsidiaryId) {
        subsidiaryService.detachSubsidiary(subsidiaryId);
    }

    @GetMapping("/subsidiary/get-by-id/{subsidiaryId}")
    @ResponseStatus(ACCEPTED)
    public SubsidiaryGetResponseDto getSubsidiaryById(@PathVariable UUID subsidiaryId) {
        return subsidiaryService.getSubsidiaryById(subsidiaryId);
    }

    @GetMapping("/subsidiary/get-by-restaurnatID/{restaurantId}/{pages}/{nrOfItems}")
    @ResponseStatus(ACCEPTED)
    public List<SubsidiaryGetResponseDto> getSubsidiaryByRestaurantId(@PathVariable UUID restaurantId, @PathVariable int pages, @PathVariable int nrOfItems) {
        return subsidiaryService.getSubsidiaryByRestaurantId(restaurantId, pages, nrOfItems);
    }
    //subsidiary endpoints end

    //drink endpoints
    @PostMapping("/drink/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDrink(@RequestBody DrinkRequestDto drinkRequestDto) {
        drinksService.saveDrink(drinkRequestDto);
    }

    @DeleteMapping("/drink/delete/{drinkId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDrinkById(@PathVariable UUID drinkId) {
        drinksService.deleteDrink(drinkId);
    }

    @GetMapping("/drink/get-by-id/{drinkId}")
    @ResponseStatus(HttpStatus.FOUND)
    public DrinkGetResponseDto getDrinkById(@PathVariable UUID drinkId) {
        return drinksService.getDrinkById(drinkId);
    }

    @GetMapping("/drink/get-by-restaurantId/{restaurantId}/{pages}/{nrOfItems}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<DrinkGetResponseDto> getDrinkByRestaurant(@PathVariable UUID restaurantId, @PathVariable int pages, @PathVariable int nrOfItems) {
        return drinksService.getDrinkByRestaurant(restaurantId, pages, nrOfItems);
    }

    @PutMapping("/drink/detach/{drinkId}")
    @ResponseStatus(HttpStatus.OK)
    public void detachDrink(@PathVariable UUID drinkId) {
        drinksService.detachDrinkFromMenu(drinkId);
    }
    //drink endpoints end
}
