package com.hexagonal.architecture.core.service.orders;

import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class UpdateOrder {
    @NonNull UUID orderId;

    @NonNull int amount;
    @NonNull BigDecimal cost;
}
