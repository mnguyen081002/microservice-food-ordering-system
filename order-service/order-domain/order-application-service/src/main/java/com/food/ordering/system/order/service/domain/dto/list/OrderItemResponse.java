package com.food.ordering.system.order.service.domain.dto.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrderItemResponse {
    private final UUID productId;
    private final String productName;
    private final BigDecimal productPrice;
    private final int productQuantity;
}
