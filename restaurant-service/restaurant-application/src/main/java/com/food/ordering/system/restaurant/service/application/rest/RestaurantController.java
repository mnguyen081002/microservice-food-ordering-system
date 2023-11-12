package com.food.ordering.system.restaurant.service.application.rest;

import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantProductsQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantProductsResponse;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantQuery;
import com.food.ordering.system.restaurant.service.domain.dto.get.GetRestaurantResponse;
import com.food.ordering.system.restaurant.service.domain.ports.input.service.RestaurantApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/restaurants", produces = "application/json")
public class RestaurantController {
    private final RestaurantApplicationService restaurantApplicationService;

    public RestaurantController(RestaurantApplicationService restaurantApplicationService) {
        this.restaurantApplicationService = restaurantApplicationService;
    }

    // Get Restaurant Information
    @GetMapping("/{restaurantId}")
    public ResponseEntity<GetRestaurantResponse> findRestaurantInformation(@PathVariable UUID restaurantId) {
        log.info("Get restaurant information for restaurantId: {}", restaurantId);
        GetRestaurantResponse response = restaurantApplicationService.findRestaurantInformation(GetRestaurantQuery.builder().restaurantId(restaurantId).build());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{restaurantId}")
    public ResponseEntity<GetRestaurantProductsResponse> getRestaurantProducts(@PathVariable UUID restaurantId) {
        log.info("Get restaurant products for restaurantId: {}", restaurantId);
        GetRestaurantProductsResponse response = restaurantApplicationService.findRestaurantProducts(GetRestaurantProductsQuery.builder().restaurantId(restaurantId).build());
        return ResponseEntity.ok(response);
    }

}
