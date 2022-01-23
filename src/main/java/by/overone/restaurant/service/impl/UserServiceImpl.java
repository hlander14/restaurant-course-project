package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.User;
import by.overone.restaurant.repository.impl.UserRepositoryImpl;
import by.overone.restaurant.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepositoryImpl userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public void deleteUser(Long idForDeletion) {
        userRepository.deleteUser(idForDeletion);
    }
}
