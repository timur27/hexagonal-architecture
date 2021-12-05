package com.hexagonal.architecture.adapters.rest;

import com.hexagonal.architecture.core.service.orders.*;
import com.hexagonal.architecture.gen.model.Order;
import com.hexagonal.architecture.gen.model.PostOrder;
import com.hexagonal.architecture.gen.rest.OrdersApi;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrdersController implements OrdersApi {

    private final GetAllOrdersHandler getAllOrdersHandler;
    private final CreateOrderHandler createOrderHandler;
    private final UpdateOrderHandler updateOrderHandler;
    private final OrdersMapper ordersMapper = Mappers.getMapper(OrdersMapper.class);

    @Override
    public ResponseEntity<List<Order>> getOrders() {
        final var result = new ArrayList<Order>();
        getAllOrdersHandler.handle(new GetAllOrders())
                .forEach(order -> {
                    result.add(ordersMapper.map(order));
                });
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Order> postOrder(PostOrder createOrder) {
        final var createdOrder = createOrderHandler.handle(new com.hexagonal.architecture.core.service.orders.CreateOrder(createOrder.getAmount(), createOrder.getCost()));
        return ResponseEntity.ok(ordersMapper.map(createdOrder));
    }

    @Override
    public ResponseEntity<Order> updateOrder(UUID orderId, PostOrder postOrder) {
        final var updatedOrder = updateOrderHandler.handle(new UpdateOrder(orderId, postOrder.getAmount(), postOrder.getCost()));
        return ResponseEntity.ok(ordersMapper.map(updatedOrder));
    }

    @Mapper
    interface OrdersMapper {
        Order map(com.hexagonal.architecture.core.domain.Order order);
    }
}