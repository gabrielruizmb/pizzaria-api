package com.pizzaria_springboot.pizzaria.features.flavour;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FlavourDTO(
    Long id,
    @NotBlank
    @Size(
        min = 2,
        max = 30,
        message = "O nome do sabor deve conter entre 2 e 30 caracteres."
    )
    String name,
    @NotBlank
    @Size(
        min = 2,
        max = 100,
        message = "Os ingredientes devem conter entre 2 e 100 caracteres."
    )
    String ingredients, 
    String imageURL
) {
    public FlavourModel convertToModel() {
        return new FlavourModel(id, name, ingredients, imageURL);
    }
}
