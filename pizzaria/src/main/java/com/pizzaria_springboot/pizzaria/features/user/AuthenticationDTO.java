package com.pizzaria_springboot.pizzaria.features.user;

import jakarta.validation.constraints.Email;

public record AuthenticationDTO(
    @Email
    String email,
    String password
) {}
