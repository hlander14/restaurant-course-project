package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.repository.IRepository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class OrderRepository implements IRepository<Order, Long> {

    @PersistenceUnit
    private EntityManager entityManager;

    @Override
    public List<Order> findAll() {
        return entityManager.unwrap(Session.class)
                .createQuery("from Order", Order.class)
                .getResultList();
    }

    @Override
    public Order findById(Long id) {
        return entityManager.unwrap(Session.class).get(Order.class, id);
    }

    @Override
    public void create(Order entity) {
        entityManager.unwrap(Session.class).saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.unwrap(Session.class)
                .createQuery("delete from Order where id =:empId")
                .setParameter("empId", id)
                .executeUpdate();
    }
}
