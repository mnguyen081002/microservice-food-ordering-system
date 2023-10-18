package com.food.ordering.system.payment.service.domain.ports.input.service;

import com.food.ordering.system.payment.service.domain.dto.DepositCommand;
import com.food.ordering.system.payment.service.domain.dto.DepositResponse;

import javax.validation.Valid;

public interface PaymentApplicationService {
    DepositResponse addCreditEntry(@Valid DepositCommand depositCommand);
}
