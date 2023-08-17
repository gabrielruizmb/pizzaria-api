package com.pizzaria_springboot.pizzaria.dtos;

import jakarta.validation.constraints.NotBlank;

public record FuncionarioRecordDto(@NotBlank String nome) {
}
