package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.payment.service.domain.entity.CreditEntry;
import com.food.ordering.system.payment.service.domain.entity.CreditHistory;
import com.food.ordering.system.payment.service.domain.entity.Deposit;

import java.util.List;

public interface DepositDomainService {
    void validateAndInitiateDeposit(Deposit deposit, CreditEntry creditEntry, List<CreditHistory> creditHistories, List<String> failureMessages);
}
