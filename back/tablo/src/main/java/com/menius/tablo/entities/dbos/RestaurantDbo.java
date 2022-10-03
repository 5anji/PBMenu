package com.menius.tablo.entities.dbos;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestaurantDbo {
    private UUID uuid;
    private String restaurantName;
    private String location;
}
