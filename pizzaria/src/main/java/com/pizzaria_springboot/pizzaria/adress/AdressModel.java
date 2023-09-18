package com.pizzaria_springboot.pizzaria.adress;

import com.pizzaria_springboot.pizzaria.AbstractEntity;
import com.pizzaria_springboot.pizzaria.user.UserModel;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private String adress;	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;
}
