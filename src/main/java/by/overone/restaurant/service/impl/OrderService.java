package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.repository.OrderRepository;
import by.overone.restaurant.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Order> optionalTrack = orderRepository.findById(id);
        if (optionalTrack.isEmpty()) {
            throw new NoSuchRestaurantException("There is no crypto with ID = " + id + " in database");
        }
        return optionalTrack.get();
    }

    @Override
    public void create(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
