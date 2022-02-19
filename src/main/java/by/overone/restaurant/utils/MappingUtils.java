package by.overone.restaurant.utils;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.dto.DishDTO;
import by.overone.restaurant.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    @Autowired
    private DishService dishService;

    public DishDTO mapToDishDto(Dish entity){
        DishDTO dto = new DishDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        dto.setPrice(entity.getPrice());

        return dto;
    }

    public Dish mapToDishEntity(DishDTO dto){
        return dishService.findById(dto.getId());
    }
}
