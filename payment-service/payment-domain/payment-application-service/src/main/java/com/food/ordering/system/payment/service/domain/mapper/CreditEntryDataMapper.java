package com.food.ordering.system.payment.service.domain.mapper;

import com.food.ordering.system.payment.service.domain.dto.CreditResponse;
import com.food.ordering.system.payment.service.domain.dto.DepositResponse;
import com.food.ordering.system.payment.service.domain.entity.CreditEntry;
import org.springframework.stereotype.Component;

@Component

public class CreditEntryDataMapper {
    public DepositResponse creditEntryToAddCreditEntryResponse(CreditEntry creditEntry) {
        return DepositResponse.builder()
                .creditEntryId(creditEntry.getId().getValue().toString())
                .customerId(creditEntry.getCustomerId().getValue())
                .message("Credit entry added successfully")
                .build();
    }

    public CreditResponse creditEntryToGetCreditResponse(CreditEntry creditEntry) {
        return CreditResponse.builder()
                .amount(creditEntry.getTotalCreditAmount().getAmount())
                .build();
    }
}
