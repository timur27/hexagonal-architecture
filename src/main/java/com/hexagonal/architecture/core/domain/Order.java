package com.hexagonal.architecture.core.domain;

import com.hexagonal.architecture.core.domain.exceptions.OrderNotCreatedException;
import com.hexagonal.architecture.core.domain.exceptions.OrderUpdateNotPossibleException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private int amount;
    private BigDecimal cost;
    private ZonedDateTime createdAt;

    private Order(int amount, BigDecimal cost, ZonedDateTime createdAt) {
        this.amount = amount;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public Order create(int amount, BigDecimal cost) {
        Optional.of(amount)
                .filter(byAllowedOrderAmount())
                .orElseThrow(() -> new OrderNotCreatedException(String.format("Order with amount %s cannot be created", amount)));

        return new Order(amount, cost, ZonedDateTime.now());
    }

    public Order update(int amount, BigDecimal cost) {
        if (Duration.between(this.createdAt, ZonedDateTime.now()).toMinutes() > 5) {
            throw new OrderUpdateNotPossibleException("Update of the order, which was created more than 5 minutes ago, is not possible.");
        }

        this.amount = amount;
        this.cost = cost;
        return this;
    }

    private Predicate<Integer> byAllowedOrderAmount() {
        return amount -> amount == 5 || amount == 10 || amount == 15;
    }
}