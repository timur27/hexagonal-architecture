package com.hexagonal.architecture.core.service.orders;

import com.hexagonal.architecture.core.domain.Order;
import com.hexagonal.architecture.core.ports.persistence.OrdersPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllOrdersHandler {

    private final OrdersPersistence ordersPersistence;

    public List<Order> handle(GetAllOrders query) {
        return ordersPersistence.getAll();
    }
}
