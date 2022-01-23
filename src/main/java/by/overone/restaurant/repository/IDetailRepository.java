package by.overone.restaurant.repository;

import by.overone.restaurant.entity.Detail;
import by.overone.restaurant.entity.Dish;

import java.util.List;

public interface IDetailRepository {

    List<Detail> findAllDetails();

    Dish findDetailById(Long id);

    void createDetail(Dish dish);

    void deleteDetail(Long idForDeletion);

}
