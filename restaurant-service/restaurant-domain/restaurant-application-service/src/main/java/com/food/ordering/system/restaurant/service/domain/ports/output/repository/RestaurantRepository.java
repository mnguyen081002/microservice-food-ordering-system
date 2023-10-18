package com.food.ordering.system.restaurant.service.domain.ports.output.repository;

import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository {
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);

    Optional<Restaurant> findRestaurantInformationById(UUID restaurantId);
}
