package com.food.ordering.system.order.service.domain.dto.list;

import com.food.ordering.system.domain.valueobject.OrderStatus;
import com.food.ordering.system.order.service.domain.valueobject.StreetAddress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrderResponse {
    private final UUID orderId;
    private final UUID restaurantId;
    private final UUID customerId;
    private final OrderStatus orderStatus;
    private final String orderTrackingId;
    private final List<String> failureMessage;
    private final StreetAddress streetAddress;
    private final BigDecimal price;
    private final List<OrderItemResponse> orderItems;
}
