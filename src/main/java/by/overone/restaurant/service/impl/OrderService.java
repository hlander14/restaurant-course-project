package by.overone.restaurant.service.impl;

import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.Order;
import by.overone.restaurant.entity.User;
import by.overone.restaurant.entity.dto.DishDTO;
import by.overone.restaurant.entity.enums.OrderStatus;
import by.overone.restaurant.exception_handling.NoSuchRestaurantException;
import by.overone.restaurant.repository.OrderRepository;
import by.overone.restaurant.repository.UserRepository;
import by.overone.restaurant.service.IService;
import by.overone.restaurant.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class OrderService implements IService<Order, Long> {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MappingUtils mappingUtils;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        Optional<Order> optionalTrack = orderRepository.findById(id);
        if (optionalTrack.isEmpty()) {
            throw new NoSuchRestaurantException("There is no order with ID = " + id + " in database");
        }
        return optionalTrack.get();
    }

    @Override
    public void create(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }


    public Long formAnOrder(String username, List<DishDTO> dishesDTOOfBasket) {
        List<Dish> dishes = mappingUtils.mapToDishList(dishesDTOOfBasket);
        User user = userRepository.findByUsername(username);
        Order order = new Order(
                LocalDateTime.now(),
                LocalDateTime.now(),
                totalPrice(dishes),
                OrderStatus.VERIFICATION,
                user,
                dishes
        );

        return 0L;
//        Order returnedOrder = orderRepository.save(order);
//
//        if (returnedOrder != null) {
//            return returnedOrder.getId();
//        } else {
//            System.out.println("Something wrong");
//            return 0L;
//        }
    }

    public Double totalPrice(List<Dish> dishes) {
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        dishes.forEach(dish -> total.set(total.get() + dish.getPrice()));
        return total.get();
    }
}
