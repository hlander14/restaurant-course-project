package by.overone.restaurant.utils;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.dto.DishDTO;
import by.overone.restaurant.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Dish> mapToDishList(List<DishDTO> dishesDTOOfBasket) {
        List<Dish> dishes = dishService.findAll();
        return dishesDTOOfBasket.stream()
                .map(dishDTO -> mapToDishEntity(dishDTO, dishes))
                .collect(Collectors.toList());
    }

    public Dish mapToDishEntity(DishDTO dto, List<Dish> dishes) {
        Dish convertedDish = null;
        try {
            convertedDish = dishes.stream()
                    .filter(dish -> dish.getId().equals(dto.getId()))
                    .findFirst()
                    .orElseThrow(() -> new ClassNotFoundException("Did not convert DTO to Dish"));
        } catch (ClassNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return convertedDish;
    }
}
