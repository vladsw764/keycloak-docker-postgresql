package com.isariev.keycloakdockerpostgresql.repository;

import com.isariev.keycloakdockerpostgresql.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findFirstByCategory(String category);
}
