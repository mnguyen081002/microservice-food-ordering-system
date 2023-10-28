package com.food.ordering.system.restaurant.service.domain;

import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantProductsQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantProductsResponse;
import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import com.food.ordering.system.restaurant.service.domain.mapper.RestaurantDataMapper;
import com.food.ordering.system.restaurant.service.domain.ports.output.repository.RestaurantRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetRestaurantProductsCommandHandler {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantDataMapper restaurantDataAccessMapper;

    public GetRestaurantProductsCommandHandler(RestaurantRepository restaurantRepository, RestaurantDataMapper restaurantDataAccessMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    public GetRestaurantProductsResponse findRestaurantProducts(GetRestaurantProductsQuery getRestaurantProductsQuery) {
        Optional<Restaurant> restaurant = restaurantRepository.findRestaurantInformationById(getRestaurantProductsQuery.getRestaurantId());
        return restaurant.map(restaurantDataAccessMapper::restaurantToGetRestaurantProductsResponse).orElse(null);
    }
}
