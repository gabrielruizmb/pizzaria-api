package com.pizzaria_springboot.pizzaria.features.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository orderRepository;

    public void post(OrderDTO orderDTO) {
        orderRepository.save(orderDTO.convertToModel());
    }
}
