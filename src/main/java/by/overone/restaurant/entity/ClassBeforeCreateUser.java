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

    @Size(min = 4, max = 10)
    @Pattern(regexp = "^\\w{4,10}$")
    private String username;

    @NotBlank(message = "Please enter your password, from 4 to 12 symbols")
    @Size(min = 4, max = 12)
    @Pattern(regexp = "^\\w{4,12}$")
    private String password;

    @NotBlank(message = "Please enter your phone number, format -> +123456789123")
    @Pattern(regexp = "^\\+\\d{12}$")
    private String phoneNumber;

    @NotBlank(message = "Please enter your e-mail")
    @Email
    private String email;
}
