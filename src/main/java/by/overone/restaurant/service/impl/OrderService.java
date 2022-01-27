package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.repository.impl.OrderRepository;
import by.overone.restaurant.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IService<Order, Long> {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void create(Order entity) {
        orderRepository.create(entity);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }
}
