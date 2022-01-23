package by.overone.restaurant.service;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUsers();

    User findUserById(Long id);

    void createUser(User user);

    void deleteUser(Long idForDeletion);

}
