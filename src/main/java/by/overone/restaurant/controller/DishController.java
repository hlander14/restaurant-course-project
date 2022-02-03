package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/api/dishes")
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/api/dishes/{id}")
    public Dish findById(@PathVariable("id") Long id) {
        return dishService.findById(id);
    }

    @PostMapping("/api/dishes")
    public Dish create(@RequestBody Dish dish) {
        dishService.create(dish);
        return dish;
    }

    @PutMapping("/api/dishes")
    public Dish update(@RequestBody Dish dish) {
        dishService.create(dish);
        return dish;
    }

    @DeleteMapping("/api/dishes/{id}")
    public String delete(@PathVariable Long id) {
        if (dishService.findById(id) == null) {
            throw new NoSuchRestaurantException("There is no employee with ID = " + id + " in database.");
        }
        dishService.delete(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
