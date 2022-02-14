package by.overone.restaurant.auth;

import java.util.Optional;

public interface IApplicationUserRepository {
    Optional<ApplicationUser> loadUserByUsername(String username);
}
