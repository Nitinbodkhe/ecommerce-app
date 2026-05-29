package com.ecommerce.backend.controller;

import com.ecommerce.backend.entity.Order;
import com.ecommerce.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.backend.repository.CartRepository;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {

        Order savedOrder = orderRepository.save(order);

        cartRepository.deleteByUserId(order.getUserId());

        return savedOrder;
    }

    @GetMapping("/user/{userId}")
    public List<Order> getUserOrders(@PathVariable Long userId) {

        return orderRepository.findByUserId(userId);
    }
}