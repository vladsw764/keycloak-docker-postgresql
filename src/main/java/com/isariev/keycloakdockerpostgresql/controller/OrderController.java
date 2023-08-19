package com.isariev.keycloakdockerpostgresql.controller;

import com.isariev.keycloakdockerpostgresql.model.Order;
import com.isariev.keycloakdockerpostgresql.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders-err")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrdersWithError() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            throw new IllegalArgumentException("I just test ProblemDetail class!))");
        }
        return orderService.getOrders();
    }

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orders/{category}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderByCategory(@PathVariable String category) {
        return orderService.getOrderByCategory(category);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping(name = "/profile-image", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadProfileImage(@RequestParam MultipartFile profilePhoto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String sub = authentication.getName();

        // TODO: upload user profile image with SUB as a key (for example AWS S3)

        return "Photo uploaded successfully";
    }
}
