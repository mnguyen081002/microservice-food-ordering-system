package com.food.ordering.system.order.service.domain.dto.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ListOrdersResponse {
    List<OrderResponse> orders;
}

