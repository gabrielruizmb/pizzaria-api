package com.pizzaria_springboot.pizzaria.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FuncionarioRecordDto(@NotBlank @Size(min = 2, max = 50, 
        message = "O nome deve conter entre 2 e 50 caracteres") String nome) {
}
