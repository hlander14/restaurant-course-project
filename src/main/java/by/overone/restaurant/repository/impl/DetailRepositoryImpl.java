package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.IDetailRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetailRepositoryImpl implements IDetailRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Detail> findAllDetails() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Details", Detail.class)
                .getResultList();
    }

    @Override
    public Dish findDetailById(Long id) {
        return null;
    }

    @Override
    public void createDetail(Dish dish) {

    }

    @Override
    public void deleteDetail(Long idForDeletion) {

    }
}
