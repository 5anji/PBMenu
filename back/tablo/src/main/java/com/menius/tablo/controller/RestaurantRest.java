package com.menius.tablo.controller;

import com.menius.tablo.service.RestaurantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tablo")
@AllArgsConstructor
public class RestaurantRest {
    private RestaurantService restaurantService;

    @GetMapping("/test")
    private void test(){
        restaurantService.test();
    }
}
