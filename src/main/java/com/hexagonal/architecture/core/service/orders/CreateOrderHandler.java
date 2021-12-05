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
        // TODO figure out another way of initializing domain object
        final var order = new Order()
                .create(cmd.getAmount(), cmd.getCost());

        return ordersPersistence.create(order);
    }
}
