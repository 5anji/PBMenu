package com.menius.tablo.entities.requests;

import com.menius.tablo.entities.enms.RestaurantStatus;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestaurantsGetRequestDto {
    private UUID restaurantId;
    private String restaurantName;
    private String restaurantPhoto;
    private RestaurantStatus restaurantStatus;
}