package com.isariev.keycloakdockerpostgresql;

import com.isariev.keycloakdockerpostgresql.model.Order;
import com.isariev.keycloakdockerpostgresql.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KeycloakDockerPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakDockerPostgresqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(OrderRepository orderRepository) {
        return args -> {
            List<Order> orders = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                Order order = new Order();
                order.setOrderName("Order " + i);
                order.setPrice(BigDecimal.valueOf(10 + i));
                order.setCategory("Books".toLowerCase());
                orders.add(order);
            }

            for (int i = 0; i < 5; i++) {
                Order order = new Order();
                order.setOrderName("Order " + i);
                order.setPrice(BigDecimal.valueOf(10 + i));
                order.setCategory("Electronics".toLowerCase());
                orders.add(order);
            }
            orderRepository.saveAll(orders);
        };
    }
}
