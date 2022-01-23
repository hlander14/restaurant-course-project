package by.overone.restaurant.controller;

import by.overone.restaurant.service.impl.DetailService;
import by.overone.restaurant.service.impl.DishService;
import by.overone.restaurant.service.impl.OrderService;
import by.overone.restaurant.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/restaurant")
public class MyController {

    @Autowired
    DetailService detailService;
    @Autowired
    DishService dishService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/auth")
    public String authorize() {
        return "auth";
    }
}
