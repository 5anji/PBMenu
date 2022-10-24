package com.menius.tablo.repository;

import com.menius.tablo.entities.RestaurantDbo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantDbo, UUID> {
    void deleteByRestaurantId(UUID restaurantId);
    Optional<RestaurantDbo> getByRestaurantId(UUID restaurantId);
//    List<RestaurantDbo> findByRestaurantId(UUID restaurantDbo, Pageable pageable);
}
