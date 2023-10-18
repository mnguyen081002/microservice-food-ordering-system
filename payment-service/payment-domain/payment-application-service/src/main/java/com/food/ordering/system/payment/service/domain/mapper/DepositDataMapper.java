package com.food.ordering.system.payment.service.domain.mapper;

import com.food.ordering.system.domain.valueobject.CustomerId;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.payment.service.domain.dto.DepositCommand;
import com.food.ordering.system.payment.service.domain.entity.Deposit;
import org.springframework.stereotype.Component;

@Component
public class DepositDataMapper {

    public Deposit depositRequestToDeposit(DepositCommand depositCommand) {
        return Deposit.builder()
                .customerId(new CustomerId(depositCommand.getCustomerId()))
                .price(new Money(depositCommand.getAmount()))
                .build();
    }
}
