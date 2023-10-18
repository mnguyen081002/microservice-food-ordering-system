package com.food.ordering.system.restaurant.service.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
public class RestaurantProductResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Boolean available;
}
