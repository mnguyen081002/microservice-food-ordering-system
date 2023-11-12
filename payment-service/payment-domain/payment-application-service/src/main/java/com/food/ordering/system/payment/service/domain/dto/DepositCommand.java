package com.food.ordering.system.payment.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class DepositCommand {
    @NotNull
    private final UUID customerId;
    @NotNull
    private final BigDecimal amount;
}
