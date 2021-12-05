package com.hexagonal.architecture.core.ports.persistence;

import com.hexagonal.architecture.core.domain.Order;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrdersPersistence {
    Order create(Order order);

    Order update(Order updatedOrder);

    List<Order> getAll();

    Optional<Order> get(@NonNull UUID orderId);
}
