package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.entity.User;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/api/users/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/api/users")
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @PutMapping("/api/users")
    public User update(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @DeleteMapping("/api/users/{id}")
    public String delete(@PathVariable Long id) {
        if (userService.findById(id) == null) {
            throw new NoSuchRestaurantException("There is no employee with ID = " + id + " in database.");
        }
        userService.delete(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
