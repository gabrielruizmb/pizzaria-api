package com.pizzaria_springboot.pizzaria;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
