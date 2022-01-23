package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.repository.impl.OrderRepositoryImpl;
import by.overone.restaurant.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepositoryImpl orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public void createOrder(Order order) {
        orderRepository.createOrder(order);
    }

    @Override
    public void deleteOrder(Long idForDeletion) {
        orderRepository.deleteOrder(idForDeletion);
    }
}
