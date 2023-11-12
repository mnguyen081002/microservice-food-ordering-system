package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.list.OrderResponse;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class GetOrdersByCustomerIdCommandHandler {
    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;

    public GetOrdersByCustomerIdCommandHandler(OrderRepository orderRepository, OrderDataMapper orderDataMapper) {
        this.orderRepository = orderRepository;
        this.orderDataMapper = orderDataMapper;
    }

    public List<OrderResponse> getOrdersByCustomerId(UUID customerId) {
        Optional<List<Order>> orders = orderRepository.findByCustomerId(customerId);
        return orderDataMapper.ordersToListOrderResponse(orders);
    }
}
