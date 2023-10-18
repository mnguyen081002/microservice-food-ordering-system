package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.payment.service.domain.dto.DepositCommand;
import com.food.ordering.system.payment.service.domain.dto.DepositResponse;
import com.food.ordering.system.payment.service.domain.ports.input.service.PaymentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentApplicationServiceImpl implements PaymentApplicationService {

    private final AddCreditEntryCommandHandler addCreditEntryCommandHandler;

    public PaymentApplicationServiceImpl(AddCreditEntryCommandHandler addCreditEntryCommandHandler) {
        this.addCreditEntryCommandHandler = addCreditEntryCommandHandler;
    }

    @Override
    public DepositResponse addCreditEntry(DepositCommand depositCommand) {
        return addCreditEntryCommandHandler.handle(depositCommand);
    }
}
