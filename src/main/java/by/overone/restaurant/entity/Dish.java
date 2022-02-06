package by.overone.restaurant.entity;

import by.overone.restaurant.entity.enums.MenuCategory;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "dishes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dishes")
    private Long id;

    @Column(name = "name_dish")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @Enumerated
    private MenuCategory category;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "dishes_has_orders"
            , joinColumns = @JoinColumn(name = "dishes_id_dishes")
            , inverseJoinColumns = @JoinColumn(name = "orders_id"))
    @JsonBackReference
    private List<Dish> dishes;

    public Dish(String name, String description, MenuCategory category, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }
}
