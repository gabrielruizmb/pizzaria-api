package com.pizzaria_springboot.pizzaria.features.flavour;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sabores")
@CrossOrigin(origins = "http://localhost:4200")
public class FlavourController {

    final FlavourService flavourService;

    public FlavourController(FlavourService flavourService) {
        this.flavourService = flavourService;
    }

    @GetMapping
    public ResponseEntity<List<FlavourDTO>> getAll() {
        try {
            return ResponseEntity.ok().body(flavourService.getAll());
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<FlavourDTO> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(flavourService.getById(id));
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> post(@RequestBody @Validated FlavourDTO flavourDTO) {
        try {
            flavourService.post(flavourDTO);
            return ResponseEntity.created(null).body(null);
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> put(
        @PathVariable Long id,
        @RequestBody @Validated FlavourDTO flavourDTO
    ) {
        try {
            flavourService.put(id, flavourDTO.convertToModel());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            flavourService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
