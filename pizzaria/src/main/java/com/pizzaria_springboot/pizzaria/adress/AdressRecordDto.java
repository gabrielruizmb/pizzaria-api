package com.pizzaria_springboot.pizzaria.adress;

import com.pizzaria_springboot.pizzaria.user.UserModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdressRecordDto(
    @NotBlank @Size(
        min = 5,
        max = 100,
        message = "O endereço deve conter entre 5 e 100 caracteres"
    ) String adress,

    UserModel user
) {}
