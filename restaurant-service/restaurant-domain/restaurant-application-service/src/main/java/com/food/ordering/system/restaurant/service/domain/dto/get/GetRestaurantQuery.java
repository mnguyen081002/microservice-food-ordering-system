package com.food.ordering.system.restaurant.service.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetRestaurantQuery {
    @NotNull
    private final UUID restaurantId;
}
