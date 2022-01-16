package by.overone.restaurant.entity;

import by.overone.restaurant.entity.enums.MenuCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dishes")
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_dish")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    @Enumerated
    private MenuCategory category;

    @Column(name = "price")
    private double price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dishes_has_orders"
            , joinColumns = @JoinColumn(name = "orders_id")
            , inverseJoinColumns = @JoinColumn(name = "dishes_id_dishes"))
    private List<Dish> dishes;

    public Dish() {}

    public Dish(String name, String description, MenuCategory category, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Dish(int id, String name, String description, MenuCategory category, double price, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && Double.compare(dish.price, price) == 0 && Objects.equals(name, dish.name) && Objects.equals(description, dish.description) && category == dish.category && Objects.equals(dishes, dish.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, price, dishes);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", dishes=" + dishes +
                '}';
    }
}
