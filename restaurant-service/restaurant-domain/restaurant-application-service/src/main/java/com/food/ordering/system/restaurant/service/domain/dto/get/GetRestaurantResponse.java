package com.food.ordering.system.restaurant.service.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetRestaurantResponse {
    private final List<RestaurantProductResponse> products;
    private UUID restaurantId;
    private boolean active;
}
