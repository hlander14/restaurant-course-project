package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.User;
import by.overone.restaurant.repository.impl.UserRepository;
import by.overone.restaurant.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void create(User entity) {
        userRepository.create(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
