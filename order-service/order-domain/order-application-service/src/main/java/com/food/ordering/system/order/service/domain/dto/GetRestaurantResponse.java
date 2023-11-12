package com.food.ordering.system.order.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class GetRestaurantResponse {
    private final List<RestaurantProductResponse> products;
    private UUID restaurantId;
    private boolean active;
}
