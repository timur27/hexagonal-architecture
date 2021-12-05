package com.hexagonal.architecture.core.service.orders;

import com.hexagonal.architecture.core.domain.Order;
import com.hexagonal.architecture.core.domain.exceptions.OrderNotFoundException;
import com.hexagonal.architecture.core.ports.persistence.OrdersPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderHandler {

    private final OrdersPersistence ordersPersistence;

    public Order handle(UpdateOrder cmd) {
        final var updatedOrder = ordersPersistence.get(cmd.getOrderId())
                .map(order -> order.update(cmd.getAmount(), cmd.getCost()))
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order with id %s was not found", cmd.getOrderId())));
        return ordersPersistence.update(updatedOrder);
    }
}
