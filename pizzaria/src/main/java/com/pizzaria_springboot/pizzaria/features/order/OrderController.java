package com.pizzaria_springboot.pizzaria.features.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    
    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> post(@RequestBody OrderDTO orderDTO) {
        try {
            orderService.post(orderDTO);
            return ResponseEntity.created(null).body(null);
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
