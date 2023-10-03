package com.pizzaria_springboot.pizzaria;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Getter
    @Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
