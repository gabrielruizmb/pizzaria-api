package com.pizzaria_springboot.pizzaria.features.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientName;
    private String clientPhoneNumber;
    private String adress;
    private String adressComplement;
    private String orderInfo;

    public OrderDTO convertoToDTO() {
        return new OrderDTO(
            id, 
            clientName, 
            clientPhoneNumber, 
            adress, 
            adressComplement, 
            orderInfo
        );
    }
}
