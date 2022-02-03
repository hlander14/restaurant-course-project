package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/api/orders")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/api/orders/{id}")
    public Order findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @PostMapping("/api/orders")
    public Order create(@RequestBody Order order) {
        orderService.create(order);
        return order;
    }

    @PutMapping("/api/orders")
    public Order update(@RequestBody Order order) {
        orderService.create(order);
        return order;
    }

    @DeleteMapping("/api/orders/{id}")
    public String delete(@PathVariable Long id) {
        if (orderService.findById(id) == null) {
            throw new NoSuchRestaurantException("There is no employee with ID = " + id + " in database.");
        }
        orderService.delete(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
