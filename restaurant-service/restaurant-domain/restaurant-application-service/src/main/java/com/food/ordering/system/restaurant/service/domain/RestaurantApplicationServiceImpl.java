package com.food.ordering.system.restaurant.service.domain;

import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantResponse;
import com.food.ordering.system.restaurant.service.domain.ports.input.service.RestaurantApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class RestaurantApplicationServiceImpl implements RestaurantApplicationService {

    private final GetRestaurantCommandHandler getRestaurantCommandHandler;

    public RestaurantApplicationServiceImpl(GetRestaurantCommandHandler getRestaurantCommandHandler) {
        this.getRestaurantCommandHandler = getRestaurantCommandHandler;
    }

    @Override
    public GetRestaurantResponse findRestaurantInformation(GetRestaurantQuery getRestaurantQuery) {
        return getRestaurantCommandHandler.findRestaurantInformation(getRestaurantQuery);
    }
}