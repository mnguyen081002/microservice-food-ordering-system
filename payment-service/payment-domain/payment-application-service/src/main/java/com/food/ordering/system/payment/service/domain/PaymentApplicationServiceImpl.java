package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.payment.service.domain.dto.CreditResponse;
import com.food.ordering.system.payment.service.domain.dto.DepositCommand;
import com.food.ordering.system.payment.service.domain.dto.DepositResponse;
import com.food.ordering.system.payment.service.domain.ports.input.service.PaymentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Slf4j
@Validated
@Service
public class PaymentApplicationServiceImpl implements PaymentApplicationService {

    private final AddCreditEntryCommandHandler addCreditEntryCommandHandler;
    private final GetCreditCommandHandler getCreditCommandHandler;

    public PaymentApplicationServiceImpl(AddCreditEntryCommandHandler addCreditEntryCommandHandler, GetCreditCommandHandler getCreditCommandHandler) {
        this.addCreditEntryCommandHandler = addCreditEntryCommandHandler;
        this.getCreditCommandHandler = getCreditCommandHandler;
    }

    @Override
    public DepositResponse addCreditEntry(DepositCommand depositCommand) {
        return addCreditEntryCommandHandler.handle(depositCommand);
    }

    @Override
    public CreditResponse getCredit(UUID xuserid) {
        return getCreditCommandHandler.handle(xuserid);
    }
}
