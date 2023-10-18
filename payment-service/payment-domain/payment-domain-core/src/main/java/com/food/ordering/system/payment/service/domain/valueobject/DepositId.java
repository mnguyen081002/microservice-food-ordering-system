package com.food.ordering.system.payment.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

import java.util.UUID;

public class DepositId extends BaseId<UUID> {
    public DepositId(UUID value) {
        super(value);
    }
}
