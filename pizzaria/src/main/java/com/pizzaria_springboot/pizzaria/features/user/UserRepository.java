package com.pizzaria_springboot.pizzaria.features.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    public boolean existsByUsername(String username);
    public UserModel findByUsername(String username);
}
