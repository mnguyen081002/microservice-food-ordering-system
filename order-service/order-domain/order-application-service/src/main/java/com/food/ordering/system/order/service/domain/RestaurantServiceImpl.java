package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.config.OrderServiceConfigData;
import com.food.ordering.system.order.service.domain.dto.GetRestaurantResponse;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Component
public class RestaurantServiceImpl implements RestaurantApplicationService {
    private final OrderServiceConfigData orderServiceConfigData;

    public RestaurantServiceImpl(OrderServiceConfigData orderServiceConfigData) {
        this.orderServiceConfigData = orderServiceConfigData;
    }

    public Optional<GetRestaurantResponse> findRestaurantInformation(Restaurant restaurant) {
        RestTemplate restTemplate = new RestTemplate();
        String url = orderServiceConfigData.getRestaurantServiceHost() + "/restaurants/" + restaurant.getId().getValue();

        ResponseEntity<GetRestaurantResponse> response = restTemplate.getForEntity(url, GetRestaurantResponse.class);
        GetRestaurantResponse restaurantInfoResponse = response.getBody();
        return Optional.ofNullable(restaurantInfoResponse);
    }
}
