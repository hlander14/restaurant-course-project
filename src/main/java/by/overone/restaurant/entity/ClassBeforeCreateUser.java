package by.overone.restaurant.entity;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClassBeforeCreateUser {
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @Size(min = 2, max = 20)
    private String surname;

    @Pattern(regexp = "^\\w{4,10}$")
    private String username;

    @Pattern(regexp = "^\\w{4,12}$", message = "Пожалуйста введите пароль, от 4 до 12 символов")
    private String password;

    @Pattern(regexp = "^\\+\\d{12}$", message = "Пожалуйста введите свой номер телефона в формате -> +123456789123")
    private String phoneNumber;

    @Email(message = "Пожалуйста введите свой e-mail")
    private String email;
}
