package com.food.ordering.system.order.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantProductResponse {
    private UUID id;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Boolean available;
}
