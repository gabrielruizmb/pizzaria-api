package com.pizzaria_springboot.pizzaria.features.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria_springboot.pizzaria.infra.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    final TokenService tokenService;
    final AuthorizationService authorizationService;
    final AuthenticationManager authenticationManager;
    
    public AuthenticationController(
        TokenService tokenService,
        AuthorizationService authorizationService,
        AuthenticationManager authenticationManager
    ) {
        this.tokenService = tokenService;
        this.authorizationService = authorizationService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
        @RequestBody 
        @Validated AuthenticationDTO user
    ) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
            user.email(), user.password()
        );
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(
        @RequestBody @Validated UserRegisterDTO newUser
    ) {
        try {
            authorizationService.createUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                exception.getMessage()
            );
        }
    }
}
