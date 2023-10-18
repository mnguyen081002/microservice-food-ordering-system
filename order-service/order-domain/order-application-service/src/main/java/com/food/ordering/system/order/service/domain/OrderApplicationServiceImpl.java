package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.list.GetOrdersByCustomerIdQuery;
import com.food.ordering.system.order.service.domain.dto.list.OrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Slf4j
@Validated
@Service
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;

    private final OrderTrackCommandHandler orderTrackCommandHandler;

    private final GetOrdersByCustomerIdCommandHandler getOrdersByCustomerIdCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler,
                                       OrderTrackCommandHandler orderTrackCommandHandler,
                                       GetOrdersByCustomerIdCommandHandler getOrdersByCustomerIdCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
        this.getOrdersByCustomerIdCommandHandler = getOrdersByCustomerIdCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }

    @Override
    public List<OrderResponse> getOrdersByCustomerId(GetOrdersByCustomerIdQuery getOrdersByCustomerIdQuery) {
        return getOrdersByCustomerIdCommandHandler.getOrdersByCustomerId(getOrdersByCustomerIdQuery.getCustomerId());
    }
}
