package com.pizzaria_springboot.pizzaria.features.order;

public record OrderDTO(
    Long id,
    String clientName,
    String clientPhoneNumber,
    String adress,
    String adressComplement,
    String orderInfo
) {
    public OrderModel convertToModel() {
        return new OrderModel(
            id, 
            clientName, 
            clientPhoneNumber, 
            adress, 
            adressComplement, 
            orderInfo
        );
    }
}
