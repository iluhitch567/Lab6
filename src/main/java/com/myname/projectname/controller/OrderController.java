package com.myname.projectname.controller;

import com.myname.projectname.model.Order;
import com.myname.projectname.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrderDetails(@PathVariable Long id, @RequestParam String details, @RequestParam double totalPrice) {
        return orderService.updateOrderDetails(id, details, totalPrice);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @DeleteMapping("/dessert/{dessertId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderByDessert(@PathVariable Long dessertId) {
        orderService.deleteOrderByDessert(dessertId);
    }
}