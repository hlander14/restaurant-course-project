package by.overone.restaurant.service.impl;

import by.overone.restaurant.controller.DishController;
import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.impl.DishRepository;
import by.overone.restaurant.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService implements IService<Dish, Long> {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id);
    }

    @Override
    public void create(Dish entity) {
        dishRepository.create(entity);
    }

    @Override
    public void delete(Long id) {
        dishRepository.delete(id);
    }
}
