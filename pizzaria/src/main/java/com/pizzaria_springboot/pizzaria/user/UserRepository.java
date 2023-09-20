package com.pizzaria_springboot.pizzaria.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    public UserModel findByName(final String name);
}
