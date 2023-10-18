package com.food.ordering.system.order.service.domain.dto.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetOrdersByCustomerIdQuery {
    private UUID customerId;
}
