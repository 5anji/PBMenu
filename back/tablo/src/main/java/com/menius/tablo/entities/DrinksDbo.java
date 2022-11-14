package com.menius.tablo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "drinks_menu")
public class DrinksDbo {
    @Id
    @GeneratedValue
    private UUID drinkId;
    @Column(unique = true, nullable = false)
    private String drinkName;
    private String drinkPhoto;
    private String drinkIngredients;
    private boolean isAlcoholic;
    @Column(nullable = false)
    private double drinkPrice;
    @Column(nullable = false)
    private boolean isDeliverable;
    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinColumn(name = "restaurant_id")
    private RestaurantDbo restaurantDbo;

}
