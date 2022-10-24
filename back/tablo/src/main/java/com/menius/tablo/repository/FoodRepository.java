package com.menius.tablo.repository;

import com.menius.tablo.entities.FoodDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<FoodDbo, UUID> {
    Optional<FoodDbo> findFoodDboByFoodId(UUID foodId);
}
