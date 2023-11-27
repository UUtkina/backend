package org.group28projectjpa_21_11.repository;


import org.group28projectjpa_21_11.entyty.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByEmail(String email);
    Optional<Manager> findByManagerName(String managerName);
}