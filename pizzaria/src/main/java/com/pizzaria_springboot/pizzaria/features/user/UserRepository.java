package com.pizzaria_springboot.pizzaria.features.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    public UserDetails findByEmail(String email);
    //public boolean existsByEmail(String email);
}
