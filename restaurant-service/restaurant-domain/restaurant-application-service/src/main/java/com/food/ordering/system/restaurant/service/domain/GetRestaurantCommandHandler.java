package com.food.ordering.system.restaurant.service.domain;

import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantResponse;
import com.food.ordering.system.restaurant.service.domain.entity.Restaurant;
import com.food.ordering.system.restaurant.service.domain.mapper.RestaurantDataMapper;
import com.food.ordering.system.restaurant.service.domain.ports.output.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class GetRestaurantCommandHandler {
    private final RestaurantDataMapper restaurantDataMapper;
    private final RestaurantRepository restaurantRepository;

    public GetRestaurantCommandHandler(RestaurantDataMapper restaurantDataMapper,
                                       RestaurantRepository restaurantRepository) {
        this.restaurantDataMapper = restaurantDataMapper;
        this.restaurantRepository = restaurantRepository;
    }

    public GetRestaurantResponse findRestaurantInformation(GetRestaurantQuery getRestaurantQuery) {
        Optional<Restaurant> restaurant = restaurantRepository.findRestaurantInformationById(getRestaurantQuery.getRestaurantId());

        if (restaurant.isPresent()) {
            return restaurantDataMapper.restaurantToGetRestaurantResponse(restaurant.get());
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }
}
