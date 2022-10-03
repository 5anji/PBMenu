package com.menius.tablo.controller;

import com.menius.tablo.entities.dbos.RestaurantDbo;
import com.menius.tablo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tablo")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RestaurantRest {
    private final RestaurantService restaurantService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private void test() {
        restaurantService.test();
    }

    @GetMapping("/test-say")
    @ResponseStatus(HttpStatus.OK)
    public String saySmth() {
        return restaurantService.saySmth();
    }

    @GetMapping("/string-list")
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantDbo> restaurantList() {
        return restaurantService.RESTAURANT_DBO();
    }
}
