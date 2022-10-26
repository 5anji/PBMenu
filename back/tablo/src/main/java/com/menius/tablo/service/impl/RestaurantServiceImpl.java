package com.menius.tablo.service.impl;

import com.menius.tablo.entities.RestaurantDbo;
import com.menius.tablo.entities.enms.RestaurantStatus;
import com.menius.tablo.entities.requests.GetNumberOfPage;
import com.menius.tablo.entities.requests.RestaurantsGetRequestDto;
import com.menius.tablo.entities.response.RestaurantsGetResponseDto;
import com.menius.tablo.repository.RestaurantRepository;
import com.menius.tablo.service.RestaurantService;
import liquibase.repackaged.org.apache.commons.collections4.IteratorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.menius.tablo.entities.enms.RestaurantStatus.AVAILABLE;
import static com.menius.tablo.entities.enms.RestaurantStatus.DETACHED;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantsGetResponseDto> getAllRestaurants(GetNumberOfPage getNumberOfPage) {
        return restaurantRepository.findAll(PageRequest.of(getNumberOfPage.getPages(), getNumberOfPage.getNrOfItems())).stream()
                .map(r -> RestaurantsGetResponseDto.builder()
                        .restaurantId(r.getRestaurantId())
                        .restaurantName(r.getRestaurantName())
                        .restaurantPhoto(r.getRestaurantPhoto())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantsGetResponseDto getRestaurantById(UUID restaurantId) {
        RestaurantDbo restaurantDbo = restaurantRepository.getByRestaurantId(restaurantId).orElseThrow();
        return RestaurantsGetResponseDto.builder()
                .restaurantId(restaurantDbo.getRestaurantId())
                .restaurantName(restaurantDbo.getRestaurantName())
                .restaurantPhoto(restaurantDbo.getRestaurantPhoto())
                .restaurantStatus(restaurantDbo.getRestaurantStatus())
                .build();
    }

    @Override
    public void saveRestaurant(RestaurantsGetRequestDto restaurantsGetRequestDto) {
        restaurantRepository.save(RestaurantDbo.builder()
                .restaurantName(restaurantsGetRequestDto.getRestaurantName())
                .restaurantPhoto(restaurantsGetRequestDto.getRestaurantPhoto())
                .restaurantStatus(AVAILABLE)
                .build());
    }

    @Override
    public void deleteRestaurantById(UUID restaurantId) {
        restaurantRepository.deleteByRestaurantId(restaurantId);
    }

    @Override
    public void detach(UUID restaurantId) {
        restaurantRepository.findById(restaurantId).ifPresent(r -> r.setRestaurantStatus(DETACHED));
    }

}
