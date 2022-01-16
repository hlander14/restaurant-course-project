package by.overone.restaurant.entity;

import by.overone.restaurant.entity.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_create_time")
    private Timestamp orderTime;

    @Column(name = "order_confirm_time")
    private Timestamp paymentTime;

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    @Enumerated
    private OrderStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dishes_has_orders"
            , joinColumns = @JoinColumn(name = "orders_id")
            , inverseJoinColumns = @JoinColumn(name = "dishes_id_dishes"))
    private List<Dish> dishes;

    public Order() {}

    public Order(Timestamp orderTime, Timestamp paymentTime, double amount, OrderStatus status, User user, List<Dish> dishes) {
        this.orderTime = orderTime;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.status = status;
        this.user = user;
        this.dishes = dishes;
    }

    public Order(int id, Timestamp orderTime, Timestamp paymentTime, double amount, OrderStatus status, User user, List<Dish> dishes) {
        this.id = id;
        this.orderTime = orderTime;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.status = status;
        this.user = user;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.amount, amount) == 0 && Objects.equals(orderTime, order.orderTime) && Objects.equals(paymentTime, order.paymentTime) && status == order.status && Objects.equals(user, order.user) && Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderTime, paymentTime, amount, status, user, dishes);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", paymentTime=" + paymentTime +
                ", amount=" + amount +
                ", status=" + status +
                ", user=" + user +
                ", dishes=" + dishes +
                '}';
    }
}
