package by.overone.restaurant.repository.impl;

import by.overone.restaurant.entity.ApplicationUser;
import by.overone.restaurant.entity.User;
import by.overone.restaurant.entity.enums.Role;
import by.overone.restaurant.repository.IApplicationUserRepository;
import by.overone.restaurant.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ApplicationUserRepository implements IApplicationUserRepository {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public Optional<ApplicationUser> loadUserByUsername(String username) {
        return getUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getUsers() {
//        List<ApplicationUser> users = List.of(
//                new ApplicationUser(
//                        Role.CLIENT.getGrantedAuthority(),
//                        "alex",
//                        passwordEncoder.encode("alex"),
//                        true, true,
//                        true, true
//                )
//        );

        List<ApplicationUser> users = new ArrayList<>();
        List<User> userList = userService.findAll();
        userList.forEach(e -> {
            ApplicationUser applicationUser = new ApplicationUser(e.getRole().getGrantedAuthority(),
                    e.getUsername(),
                    e.getPassword(),
                    true, true, true, true);
            users.add(applicationUser);
        });
        return users;
    }
}
