package com.food.ordering.system.restaurant.service.domain.ports.input.service;

import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantProductsQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantProductsResponse;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantResponse;

import javax.validation.Valid;

public interface RestaurantApplicationService {
    GetRestaurantResponse findRestaurantInformation(@Valid GetRestaurantQuery getRestaurantQuery);

    GetRestaurantProductsResponse findRestaurantProducts(@Valid GetRestaurantProductsQuery getRestaurantProductsQuery);
}
