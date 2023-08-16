package com.isariev.keycloakdockerpostgresql.service;

import com.isariev.keycloakdockerpostgresql.model.Order;
import com.isariev.keycloakdockerpostgresql.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderByCategory(String category) {
        return orderRepository.findFirstByCategory(category)
                .orElseThrow(() -> new IllegalArgumentException("error :("));
    }
}
