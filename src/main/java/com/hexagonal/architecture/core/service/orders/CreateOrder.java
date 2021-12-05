package com.hexagonal.architecture.core.service.orders;

import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateOrder {
    @NonNull int amount;
    @NonNull BigDecimal cost;
}
