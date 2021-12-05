package com.hexagonal.architecture.persistence;

import com.hexagonal.architecture.core.domain.Order;
import com.hexagonal.architecture.core.ports.persistence.OrdersPersistence;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface InMemoryRepository extends CrudRepository<Order, UUID>{

}
