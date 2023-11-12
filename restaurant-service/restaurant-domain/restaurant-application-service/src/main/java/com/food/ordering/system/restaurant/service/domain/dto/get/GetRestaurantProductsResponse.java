package com.food.ordering.system.restaurant.service.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class GetRestaurantProductsResponse {
    List<RestaurantProductResponse> products;
}
