package com.menius.tablo.entities.requests;

import com.menius.tablo.entities.RestaurantDbo;
import com.menius.tablo.entities.enms.FoodStatus;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FoodRequestDto {
    private UUID foodId;
    private String foodName;
    private String foodPhoto;
    private String foodIngredients;
    private RestaurantDbo restaurantDbo;
    private FoodStatus foodStatus;
    private boolean isSpicy;
    private boolean isVegetarian;
    private boolean isDeliverable;
    private double foodPrice;
}