package com.food.ordering.system.order.service.domain.ports.output.repository;

import com.food.ordering.system.order.service.domain.dto.GetRestaurantResponse;
import com.food.ordering.system.order.service.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantApplicationService {

    Optional<GetRestaurantResponse> findRestaurantInformation(Restaurant restaurant);
}
