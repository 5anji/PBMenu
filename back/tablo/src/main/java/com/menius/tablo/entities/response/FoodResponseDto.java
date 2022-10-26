package com.menius.tablo.entities.response;

import com.menius.tablo.entities.RestaurantDbo;
import com.menius.tablo.entities.enms.FoodStatus;
import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FoodResponseDto {
    private UUID foodId;
    private String foodName;
    private String foodPhoto;
    private String foodIngredients;
    private RestaurantDbo restaurantDbo;
    private FoodStatus foodStatus;
}
