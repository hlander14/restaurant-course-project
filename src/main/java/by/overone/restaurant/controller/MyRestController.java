package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.service.impl.DetailServiceImpl;
import by.overone.restaurant.service.impl.DishServiceImpl;
import by.overone.restaurant.service.impl.OrderServiceImpl;
import by.overone.restaurant.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    DetailServiceImpl detailService;
    @Autowired
    DishServiceImpl dishService;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    UserServiceImpl userService;


    @GetMapping("/dishes")
    public List<Dish> getAllDishes() {
        System.out.println("GET MY FUCKING DISH!!!!!");
        List<Dish> dishes = dishService.findAllDishes();
        System.out.println(dishes + "    !!!!!!!");
        return dishes;
    }
}
