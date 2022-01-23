package by.overone.restaurant.repository;

import by.overone.restaurant.entity.Dish;

import java.util.List;

public interface IDishesRepository {

    List<Dish> findAllDishes();

    Dish findDishById(Long id);

    void createDish(Dish dish);

    void deleteDish(Long idForDeletion);

}
