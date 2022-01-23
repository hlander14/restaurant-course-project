package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.repository.IOrderRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements IOrderRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Order> findAllOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Orders", Order.class)
                .getResultList();
    }

    @Override
    public Order findOrderById(Long id) {
        return null;
    }

    @Override
    public void createOrder(Order dish) {

    }

    @Override
    public void deleteOrder(Long idForDeletion) {

    }
}
