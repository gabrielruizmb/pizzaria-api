package com.pizzaria_springboot.pizzaria.features.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long>{
    
}
