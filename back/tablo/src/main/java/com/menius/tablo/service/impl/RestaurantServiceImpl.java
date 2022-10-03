package com.menius.tablo.service.impl;

import com.menius.tablo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    @Override
    public void test() {
        System.out.println("Hello World!");
    }

    @Override
    public String saySmth() {
        return "Hi, Guys";
    }

    @Override
    public List<String> STRINGS() {
        return List.of("first, ", "second", "third");
    }
}
