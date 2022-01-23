package by.overone.restaurant.repository;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAllUsers();

    User findUserById(Long id);

    void createUser(User user);

    void deleteUser(Long idForDeletion);

}
