package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.User;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.repository.UserRepository;
import by.overone.restaurant.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> optionalTrack = userRepository.findById(id);
        if (optionalTrack.isEmpty()) {
            throw new NoSuchRestaurantException("There is no order with ID = " + id + " in database");
        }
        return optionalTrack.get();
    }

    @Override
    public void create(User entity) {
        userRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
