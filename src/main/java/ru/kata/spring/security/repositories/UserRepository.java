package ru.kata.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.security.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select u from User u left join fetch u.roles where u.email = :email")
    Optional<User> findByEmail(String email);
}
