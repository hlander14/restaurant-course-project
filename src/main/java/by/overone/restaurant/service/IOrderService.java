package by.overone.restaurant.service;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.Order;

import java.util.List;

public interface IOrderService {

    List<Order> findAllOrders();

    Order findOrderById(Long id);

    void createOrder(Order order);

    void deleteOrder(Long idForDeletion);

}
