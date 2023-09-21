package com.pizzaria_springboot.pizzaria.user;

import com.pizzaria_springboot.pizzaria.AbstractEntity;
import com.pizzaria_springboot.pizzaria.adress.AdressModel;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "tb_users")
public class UserModel extends AbstractEntity {
	private String username;
	private String password;
	private String name;
	private boolean admin;
	@OneToOne
	@JoinColumn(name = "adress_id")
	private AdressModel adress;
}