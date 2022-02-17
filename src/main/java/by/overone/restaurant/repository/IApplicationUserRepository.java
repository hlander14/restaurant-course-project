package by.overone.restaurant.repository;

import by.overone.restaurant.entity.ApplicationUser;

import java.util.Optional;

public interface IApplicationUserRepository {
    Optional<ApplicationUser> loadUserByUsername(String username);
}
