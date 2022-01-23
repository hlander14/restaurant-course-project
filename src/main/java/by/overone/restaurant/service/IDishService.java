package by.overone.restaurant.service;

import by.overone.restaurant.entity.Dish;

import java.util.List;

public interface IDishService {

    List<Dish> findAllDishes();

    Dish findDishById(Long id);

    void createDish(Dish dish);

    void deleteDish(Long idForDeletion);
}