package by.overone.restaurant.entity.dto;

import by.overone.restaurant.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private Role role;
    private double balance;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
}
