package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.domain.valueobject.CustomerId;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.payment.service.domain.dto.DepositCommand;
import com.food.ordering.system.payment.service.domain.dto.DepositResponse;
import com.food.ordering.system.payment.service.domain.entity.CreditEntry;
import com.food.ordering.system.payment.service.domain.entity.CreditHistory;
import com.food.ordering.system.payment.service.domain.entity.Deposit;
import com.food.ordering.system.payment.service.domain.mapper.CreditEntryDataMapper;
import com.food.ordering.system.payment.service.domain.mapper.DepositDataMapper;
import com.food.ordering.system.payment.service.domain.ports.output.repository.CreditEntryRepository;
import com.food.ordering.system.payment.service.domain.ports.output.repository.CreditHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class AddCreditEntryCommandHandler {
    private final CreditEntryRepository creditEntryRepository;
    private final CreditEntryDataMapper creditEntryDataMapper;
    private final DepositDataMapper depositDataMapper;
    private final CreditHistoryRepository creditHistoryRepository;
    private final DepositDomainService depositDomainService;

    public AddCreditEntryCommandHandler(CreditEntryRepository creditEntryRepository, CreditEntryDataMapper creditEntryDataMapper, DepositDataMapper depositDataMapper, CreditHistoryRepository creditHistoryRepository, DepositDomainService depositDomainService) {
        this.creditEntryRepository = creditEntryRepository;
        this.creditEntryDataMapper = creditEntryDataMapper;
        this.depositDataMapper = depositDataMapper;
        this.creditHistoryRepository = creditHistoryRepository;
        this.depositDomainService = depositDomainService;
    }

    public DepositResponse handle(DepositCommand depositCommand) {
        log.info("Received deposit complete event for order id: {}", depositCommand.getCustomerId());
        Deposit deposit = depositDataMapper.depositRequestToDeposit(depositCommand);

        CreditEntry creditEntry = getCreditEntryOrInit(depositCommand.getCustomerId());
        List<CreditHistory> creditHistories = getCreditHistory(depositCommand.getCustomerId());
        List<String> failureMessages = new ArrayList<>();
        depositDomainService.validateAndInitiateDeposit(deposit, creditEntry, creditHistories, failureMessages);
        persistDbObjects(deposit, creditEntry, creditHistories, failureMessages);
        return creditEntryDataMapper.creditEntryToAddCreditEntryResponse(creditEntry);
    }

    private void persistDbObjects(Deposit deposit, CreditEntry creditEntry, List<CreditHistory> creditHistories, List<String> failureMessages) {
        creditEntryRepository.save(creditEntry);
        log.debug("HIHIH {}", creditHistories.get(creditHistories.size() - 1).getAmount());
        log.debug("HIHIH222 {}", creditEntry.getTotalCreditAmount().getAmount());

        creditHistoryRepository.save(creditHistories.get(creditHistories.size() - 1));
        if (failureMessages.isEmpty()) {
            log.info("Successfully saved credit entry for customer id: {}", deposit.getCustomerId().getValue());
        } else {
            log.error("Failed to save credit entry for customer id: {}. Failure messages: {}",
                    deposit.getCustomerId().getValue(), failureMessages);
        }
    }

    private List<CreditHistory> getCreditHistory(UUID customerId) {
        Optional<List<CreditHistory>> creditHistoriesOptional = creditHistoryRepository.findByCustomerId(new CustomerId(customerId));
        return creditHistoriesOptional.get();
    }

    private CreditEntry getCreditEntryOrInit(UUID customerId) {
        Optional<CreditEntry> creditEntryOptional = creditEntryRepository.findByCustomerId(new CustomerId(customerId));
        return creditEntryOptional.orElseGet(() -> new CreditEntry(new CustomerId(customerId), Money.ZERO));
    }
}
