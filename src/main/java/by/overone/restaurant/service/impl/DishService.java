package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.impl.DishesRepository;
import by.overone.restaurant.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService implements IDishService {

    @Autowired
    DishesRepository dishesRepository;

    @Override
    public List<Dish> findAllDishes() {
        return dishesRepository.findAllDishes();
    }

    @Override
    public Dish findDishById(Long id) {
        return dishesRepository.findDishById(id);
    }

    @Override
    public void createDish(Dish dish) {
        dishesRepository.createDish(dish);
    }

    @Override
    public void deleteDish(Long idForDeletion) {
        dishesRepository.deleteDish(idForDeletion);
    }
}
