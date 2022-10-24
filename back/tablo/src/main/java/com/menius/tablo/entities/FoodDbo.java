package com.menius.tablo.entities;

import com.menius.tablo.entities.enms.FoodStatus;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "food_menu")
public class FoodDbo {
    @Id
    @GeneratedValue
    private UUID foodId;
    @Column(nullable = false, unique = true)
    private String foodName;
    private String foodPhoto;
    private String foodIngredients;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumn(name = "restaurant_id")
    private RestaurantDbo restaurantDbo;
    @Enumerated(EnumType.STRING)
    private FoodStatus foodStatus;
}
