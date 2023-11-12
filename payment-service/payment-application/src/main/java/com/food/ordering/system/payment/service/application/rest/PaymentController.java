package com.food.ordering.system.payment.service.application.rest;

import com.food.ordering.system.payment.service.domain.dto.CreditResponse;
import com.food.ordering.system.payment.service.domain.dto.DepositCommand;
import com.food.ordering.system.payment.service.domain.dto.DepositResponse;
import com.food.ordering.system.payment.service.domain.ports.input.service.PaymentApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/payments", produces = "application/json")
public class PaymentController {
    private final PaymentApplicationService paymentApplicationService;

    public PaymentController(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    @PostMapping("/add-credit-entry")
    public ResponseEntity<DepositResponse> addCreditEntry(@RequestBody DepositCommand depositCommand) {
        return ResponseEntity.ok(paymentApplicationService.addCreditEntry(depositCommand));
    }

    @GetMapping("/credit")
    public ResponseEntity<CreditResponse> getCredit(@RequestHeader("X-User-Id") UUID xuserid) {
        return ResponseEntity.ok(paymentApplicationService.getCredit(xuserid));
    }
}
