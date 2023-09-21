package com.pizzaria_springboot.pizzaria.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    public UserModel findByUsername(final String username);
}