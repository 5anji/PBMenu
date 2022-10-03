package com.menius.tablo.controller;

import com.menius.tablo.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tablo")
@AllArgsConstructor
public class RestaurantRest {
    private RestaurantService restaurantService;

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private void test() {
        restaurantService.test();
    }

    @GetMapping("/test-say")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String saySmth() {
        return restaurantService.saySmth();
    }
}
