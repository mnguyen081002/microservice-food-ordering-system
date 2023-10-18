package com.food.ordering.system.order.service.domain.ports.output.repository;

import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.valueobject.TrackingId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(TrackingId trackingId);

    Optional<List<Order>> findByCustomerId(UUID customerId);
}
