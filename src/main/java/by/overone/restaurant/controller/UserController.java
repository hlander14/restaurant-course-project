package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.entity.User;
import by.overone.restaurant.entity.enums.Role;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        userService.create(user);
        return user;
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        if (userService.findById(id) == null) {
            throw new NoSuchRestaurantException("There is no employee with ID = " + id + " in database.");
        }
        userService.delete(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
