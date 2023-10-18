package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.payment.service.domain.entity.CreditEntry;
import com.food.ordering.system.payment.service.domain.entity.CreditHistory;
import com.food.ordering.system.payment.service.domain.entity.Deposit;
import com.food.ordering.system.payment.service.domain.valueobject.CreditHistoryId;
import com.food.ordering.system.payment.service.domain.valueobject.TransactionType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public class DepositDomainServiceImpl implements DepositDomainService {
    @Override
    public void validateAndInitiateDeposit(Deposit deposit, CreditEntry creditEntry, List<CreditHistory> creditHistories, List<String> failureMessages) {
        deposit.validateDeposit(failureMessages);
        addCreditEntry(deposit, creditEntry);
        updateCreditHistory(deposit, creditHistories);
        if (failureMessages.isEmpty()) {
            log.info("Deposit is initiated for customer id: {}", deposit.getCustomerId().getValue());
        } else {
            log.error("Deposit initiation is failed for customer id: {}", deposit.getCustomerId().getValue());
        }
    }

    private void updateCreditHistory(Deposit deposit, List<CreditHistory> creditHistories) {
        CreditHistory creditHistory = CreditHistory.builder()
                .creditHistoryId(new CreditHistoryId(UUID.randomUUID()))
                .customerId(deposit.getCustomerId())
                .amount(deposit.getPrice())
                .transactionType(TransactionType.CREDIT)
                .build();
        creditHistories.add(creditHistory);
    }

    private void addCreditEntry(Deposit deposit, CreditEntry creditEntry) {
        creditEntry.addCreditAmount(deposit.getPrice());
    }
}
