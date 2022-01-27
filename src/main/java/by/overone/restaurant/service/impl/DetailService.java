package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.repository.impl.DetailRepository;
import by.overone.restaurant.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService implements IService<Detail, Long> {

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail findById(Long id) {
        return detailRepository.findById(id);
    }

    @Override
    public void create(Detail entity) {
        detailRepository.create(entity);
    }

    @Override
    public void delete(Long id) {
        detailRepository.delete(id);
    }
}
