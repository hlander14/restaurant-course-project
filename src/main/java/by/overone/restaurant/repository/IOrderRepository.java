package by.overone.restaurant.repository;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.Order;

import java.util.List;

public interface IOrderRepository {

    List<Order> findAllOrders();

    Order findOrderById(Long id);

    void createOrder(Order dish);

    void deleteOrder(Long idForDeletion);

}
