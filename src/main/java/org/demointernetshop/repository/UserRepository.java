package org.demointernetshop.repository;

import org.demointernetshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}