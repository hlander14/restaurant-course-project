package by.overone.restaurant.entity;


import by.overone.restaurant.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated
    private Role role;

    @Column(name = "balance")
    private double balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Detail detail;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> orders;

    public User(String username, String password, Role role, double balance, Detail detail, List<Order> orders) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.detail = detail;
        this.orders = orders;
    }
}
