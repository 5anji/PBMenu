package com.menius.tablo.service.impl;

import com.menius.tablo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    @Override
    public void test() {
        System.out.println("Hello World!");
    }
}
