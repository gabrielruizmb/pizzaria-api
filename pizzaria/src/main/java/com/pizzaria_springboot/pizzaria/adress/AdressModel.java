package com.pizzaria_springboot.pizzaria.adress;

import com.pizzaria_springboot.pizzaria.AbstractEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_adresses")
public class AdressModel extends AbstractEntity{
	private String CEP;
	private String district;
	private String street;
	private String number;
	private String complement;
}
