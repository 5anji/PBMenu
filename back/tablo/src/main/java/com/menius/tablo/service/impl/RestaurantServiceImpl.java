package com.menius.tablo.service.impl;

import com.menius.tablo.entities.dbos.RestaurantDbo;
import com.menius.tablo.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

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
    public List<Integer> STRINGS() {
        Random random = new Random();
        return List.of(random.nextInt());
    }

    @Override
    public List<RestaurantDbo> RESTAURANT_DBO() {
        return List.of(
                new RestaurantDbo(UUID.randomUUID(), "Andy's Pizza", "str. ZXC 43"),
                new RestaurantDbo(UUID.randomUUID(), "Saperavi", "str. REW 43"),
                new RestaurantDbo(UUID.randomUUID(), "Bruno", "str. YTR 43")
                );
    }
}
