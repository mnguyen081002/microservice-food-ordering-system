package com.food.ordering.system.order.service.dataaccess.order.repository;

import com.food.ordering.system.order.service.dataaccess.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

    Optional<OrderEntity> findByTrackingId(UUID trackingId);

    @Query(value = "SELECT * FROM orders o LEFT JOIN order_items a ON a.order_id = o.id WHERE o.customer_id = :customerId", nativeQuery = true)
    Optional<List<OrderEntity>> findByCustomerId(UUID customerId);
}
