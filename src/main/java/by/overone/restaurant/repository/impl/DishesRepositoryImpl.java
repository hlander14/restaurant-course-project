package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.IDishesRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishesRepositoryImpl implements IDishesRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Dish> findAllDishes() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Dish", Dish.class)
                .getResultList();
    }

    @Override
    public Dish findDishById(Long id) {
        return null;
    }

    @Override
    public void createDish(Dish dish) {

    }

    @Override
    public void deleteDish(Long idForDeletion) {

    }
}
