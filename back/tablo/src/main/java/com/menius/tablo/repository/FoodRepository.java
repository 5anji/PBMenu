package com.menius.tablo.repository;

import com.menius.tablo.entities.FoodDbo;
import com.menius.tablo.entities.RestaurantDbo;
import com.menius.tablo.entities.enms.FoodStatus;
import com.menius.tablo.entities.response.RestaurantsGetResponseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<FoodDbo, UUID> {
    Optional<FoodDbo> findFoodDboByFoodId(UUID foodId);
    List<FoodDbo> findFoodDboByRestaurantDbo(RestaurantDbo restaurantDbo, Pageable pageable);
 }
