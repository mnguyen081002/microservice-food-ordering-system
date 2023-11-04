package com.food.ordering.system.payment.service.domain;

import com.food.ordering.system.domain.valueobject.CustomerId;
import com.food.ordering.system.payment.service.domain.dto.CreditResponse;
import com.food.ordering.system.payment.service.domain.entity.CreditEntry;
import com.food.ordering.system.payment.service.domain.mapper.CreditEntryDataMapper;
import com.food.ordering.system.payment.service.domain.ports.output.repository.CreditEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@Service
public class GetCreditCommandHandler {
    private final CreditEntryRepository creditEntryRepository;
    private final CreditEntryDataMapper creditEntryDataMapper;

    public GetCreditCommandHandler(CreditEntryRepository creditEntryRepository, CreditEntryDataMapper creditEntryDataMapper) {
        this.creditEntryRepository = creditEntryRepository;
        this.creditEntryDataMapper = creditEntryDataMapper;
    }

    public CreditResponse handle(UUID xuserid) {
        log.info("Received get credit event for customer id: {}", xuserid);
        Optional<CreditEntry> creditEntry = creditEntryRepository.findByCustomerId(new CustomerId(xuserid));
        if (creditEntry.isEmpty()) {
            log.info("No credit entry found for customer id: {}", xuserid);
            return CreditResponse.builder()
                    .amount(BigDecimal.ZERO)
                    .build();
        }
        return creditEntryDataMapper.creditEntryToGetCreditResponse(creditEntry.get());
    }
}
