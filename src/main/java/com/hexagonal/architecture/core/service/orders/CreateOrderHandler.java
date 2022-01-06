package com.hexagonal.architecture.core.service.orders;

import com.hexagonal.architecture.core.domain.Order;
import com.hexagonal.architecture.core.ports.persistence.OrdersPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateOrderHandler {
    private final OrdersPersistence ordersPersistence;

    public Order handle(CreateOrder cmd) {
        final var order = Order.create()
                .setup(cmd.getAmount(), cmd.getCost());

        return ordersPersistence.create(order);
    }
}
