package com.food.ordering.application.system.payment.service.application.rest;

import com.food.ordering.system.payment.service.domain.dto.AddCreditEntryCommand;
import com.food.ordering.system.payment.service.domain.dto.AddCreditEntryResponse;
import com.food.ordering.system.payment.service.domain.ports.input.service.PaymentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/payments", produces = "application/json")
public class PaymentController {
    private final PaymentApplicationService paymentApplicationService;

    public PaymentController(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    @PostMapping("/add-credit-entry")
    public ResponseEntity<AddCreditEntryResponse> addCreditEntry(@RequestBody AddCreditEntryCommand addCreditEntryCommand) {
        return ResponseEntity.ok(paymentApplicationService.addCreditEntry(addCreditEntryCommand));
    }
}
