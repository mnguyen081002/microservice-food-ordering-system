package com.food.ordering.system.payment.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class AddCreditEntryResponse {
    @NotNull
    private final String message;
    @NotNull
    private final String creditEntryId;
    @NotNull
    private final UUID customerId;
}

