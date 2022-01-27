package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.repository.IRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class DetailRepository implements IRepository<Detail, Long> {

    @PersistenceUnit
    private EntityManager entityManager;

    @Override
    public List<Detail> findAll() {
        return entityManager.unwrap(Session.class)
                .createQuery("from Detail", Detail.class)
                .getResultList();
    }

    @Override
    public Detail findById(Long id) {
        return entityManager.unwrap(Session.class).get(Detail.class, id);
    }

    @Override
    public void create(Detail entity) {
        entityManager.unwrap(Session.class).saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        entityManager.unwrap(Session.class)
                .createQuery("delete from Detail where id =:empId")
                .setParameter("empId", id)
                .executeUpdate();
    }
}
