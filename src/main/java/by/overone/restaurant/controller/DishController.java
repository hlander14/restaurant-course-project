package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.enums.MenuCategory;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("")
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable("id") Long id) {
        return dishService.findById(id);
    }

    @PostMapping("")
    public Dish create(@RequestBody Dish dish) {
        dishService.create(dish);
        return dish;
    }

    @PutMapping("")
    public Dish update(@RequestBody Dish dish) {
        dishService.create(dish);
        return dish;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        if (dishService.findById(id) == null) {
            throw new NoSuchRestaurantException("There is no employee with ID = " + id + " in database.");
        }
        dishService.delete(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
