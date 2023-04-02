package com.bsuir.cardealership.repository;

import com.bsuir.cardealership.model.ERole;
import com.bsuir.cardealership.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}