package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.impl.DetailRepositoryImpl;
import by.overone.restaurant.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements IDetailService {

    @Autowired
    DetailRepositoryImpl detailRepository;

    @Override
    public List<Detail> findAllDetails() {
        return detailRepository.findAllDetails();
    }

    @Override
    public Dish findDetailById(Long id) {
        return detailRepository.findDetailById(id);
    }

    @Override
    public void createDetail(Dish dish) {
        detailRepository.createDetail(dish);
    }

    @Override
    public void deleteDetail(Long idForDeletion) {
        detailRepository.deleteDetail(idForDeletion);
    }
}
