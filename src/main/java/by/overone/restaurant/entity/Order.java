package by.overone.restaurant.entity;

import by.overone.restaurant.entity.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_create_time")
    private LocalDateTime orderTime;

    @Column(name = "order_confirm_time")
    private LocalDateTime paymentTime;

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    @Enumerated
    private OrderStatus status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "dishes_has_orders"
            , joinColumns = @JoinColumn(name = "orders_id")
            , inverseJoinColumns = @JoinColumn(name = "dishes_id_dishes"))
    private List<Dish> dishes;

    public Order(LocalDateTime orderTime, LocalDateTime paymentTime, double amount, OrderStatus status, User user, List<Dish> dishes) {
        this.orderTime = orderTime;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.status = status;
        this.user = user;
        this.dishes = dishes;
    }
}
