package com.isariev.keycloakdockerpostgresql.controller;

import com.isariev.keycloakdockerpostgresql.model.Order;
import com.isariev.keycloakdockerpostgresql.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{category}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderByCategory(@PathVariable String category) {
        return orderService.getOrderByCategory(category);
    }
}
