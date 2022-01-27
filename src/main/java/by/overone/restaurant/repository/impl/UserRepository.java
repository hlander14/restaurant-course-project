package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.User;
import by.overone.restaurant.repository.IRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class UserRepository implements IRepository<User, Long> {

    @PersistenceUnit
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.unwrap(Session.class)
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.unwrap(Session.class).get(User.class, id);
    }

    @Override
    public void create(User entity) {
        entityManager.unwrap(Session.class).saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.unwrap(Session.class)
                .createQuery("delete from User where id =:empId")
                .setParameter("empId", id)
                .executeUpdate();
    }
}
