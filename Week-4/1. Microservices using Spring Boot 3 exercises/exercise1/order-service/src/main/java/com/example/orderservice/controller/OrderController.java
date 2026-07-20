package com.example.orderservice.controller;

import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.dto.UserDto;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> responses = new ArrayList<>();
        for (Order order : orders) {
            UserDto user = null;
            try {
                user = userClient.getUserById(order.getUserId());
            } catch (Exception e) {
                // Fallback if user service is down
                user = new UserDto(order.getUserId(), "Unknown (User Service Down)", "");
            }
            responses.add(new OrderResponse(order, user));
        }
        return responses;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    UserDto user = null;
                    try {
                        user = userClient.getUserById(order.getUserId());
                    } catch (Exception e) {
                        user = new UserDto(order.getUserId(), "Unknown", "");
                    }
                    return ResponseEntity.ok(new OrderResponse(order, user));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
