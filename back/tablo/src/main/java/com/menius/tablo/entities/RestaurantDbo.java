package com.menius.tablo.entities;

import com.menius.tablo.entities.enms.RestaurantStatus;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "restaurant")
    public class RestaurantDbo {
    @Id
    @GeneratedValue
    private UUID restaurantId;
    @Column(nullable = false)
    private String restaurantName;
    @Column(nullable = false, unique = true)
    private String restaurantPhoto;
    @Enumerated(EnumType.STRING)
    private RestaurantStatus restaurantStatus;
}
