package com.hexagonal.architecture.core.service.orders;

import com.hexagonal.architecture.core.domain.Order;
import com.hexagonal.architecture.core.ports.persistence.OrdersPersistence;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class CreateOrderHandlerTest {

    @Mock
    private OrdersPersistence ordersPersistence;
    @InjectMocks
    private CreateOrderHandler underTest;

    private final int amount = 1;
    private final BigDecimal cost = BigDecimal.ONE;

    @Test
    void test_orderCreated() {
        when(ordersPersistence.create(any())).thenReturn(createdOrder());

        final var result = underTest.handle(new CreateOrder(amount, cost));

        assertThat(result).isNotNull();
        assertThat(result.getCreatedAt()).isBefore(ZonedDateTime.now());
        assertThat(result.getAmount()).isEqualTo(amount);
        assertThat(result.getCost()).isEqualTo(cost);
    }

    private Order createdOrder() {
        return Order.create()
                .setup(amount, cost);
    }

}