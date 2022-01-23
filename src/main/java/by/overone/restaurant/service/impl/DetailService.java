package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.repository.impl.DetailRepository;
import by.overone.restaurant.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService implements IDetailService {

    @Autowired
    DetailRepository detailRepository;

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
