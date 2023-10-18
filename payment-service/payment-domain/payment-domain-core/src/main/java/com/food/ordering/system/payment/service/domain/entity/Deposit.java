package com.food.ordering.system.payment.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueobject.CustomerId;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.payment.service.domain.valueobject.DepositId;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
public class Deposit extends AggregateRoot<DepositId> {
    private final CustomerId customerId;
    private final Money price;
    private ZonedDateTime createdAt;

    public void validateDeposit(List<String> failureMessages) {
        if (price == null || !price.isGreaterThanZero()) {
            failureMessages.add("Total price must be greater than zero!");
        }
    }
}
