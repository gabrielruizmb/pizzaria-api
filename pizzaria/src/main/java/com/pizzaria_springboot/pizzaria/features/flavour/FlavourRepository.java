package com.pizzaria_springboot.pizzaria.features.flavour;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlavourRepository extends JpaRepository<FlavourModel, Long> {
    public boolean existsByName(String name);
    public FlavourModel findByName(String name);
}
