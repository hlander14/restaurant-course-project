package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.User;
import by.overone.restaurant.repository.IUserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Users", User.class)
                .getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(Long idForDeletion) {

    }
}
