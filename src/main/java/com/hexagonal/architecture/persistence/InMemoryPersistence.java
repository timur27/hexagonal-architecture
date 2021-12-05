package com.hexagonal.architecture.persistence;

import com.hexagonal.architecture.core.domain.Order;
import com.hexagonal.architecture.core.ports.persistence.OrdersPersistence;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InMemoryPersistence implements OrdersPersistence {

    private final InMemoryRepository inMemoryRepository;

    @Override
    public Order create(Order order) {
        return inMemoryRepository.save(order);
    }

    @Override
    public Order update(Order updatedOrder) {
        return inMemoryRepository.save(updatedOrder);
    }

    @Override
    public List<Order> getAll() {
        final var result = new ArrayList<Order>();
        inMemoryRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Optional<Order> get(@NonNull UUID orderId) {
        return inMemoryRepository.findById(orderId);
    }
}
