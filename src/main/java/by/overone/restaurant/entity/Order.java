package by.overone.restaurant.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "restaurant.orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_time")
    private Timestamp orderTime;

    @Column(name = "payment_time")
    private Timestamp paymentTime;

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    private String status;

    public Order() {}

    public Order(Timestamp orderTime, Timestamp paymentTime, double amount, String status) {
        this.orderTime = orderTime;
        this.paymentTime = paymentTime;
        this.amount = amount;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.amount, amount) == 0 && Objects.equals(orderTime, order.orderTime) && Objects.equals(paymentTime, order.paymentTime) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderTime, paymentTime, amount, status);
    }
}
