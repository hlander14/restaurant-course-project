package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.IRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class DishRepository implements IRepository<Dish, Long> {

    @PersistenceUnit
    private EntityManager entityManager;

    @Override
    public List<Dish> findAll() {
        return entityManager.unwrap(Session.class)
                .createQuery("from Dish", Dish.class)
                .getResultList();
    }

    @Override
    public Dish findById(Long id) {
        return entityManager.unwrap(Session.class).get(Dish.class, id);
    }

    @Override
    public void create(Dish entity) {
        entityManager.unwrap(Session.class).saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.unwrap(Session.class)
                .createQuery("delete from Dish where id =:empId")
                .setParameter("empId", id)
                .executeUpdate();
    }
}
