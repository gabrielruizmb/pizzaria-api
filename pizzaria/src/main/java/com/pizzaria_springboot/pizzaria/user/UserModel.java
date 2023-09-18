package com.pizzaria_springboot.pizzaria.user;

import java.util.List;

import com.pizzaria_springboot.pizzaria.AbstractEntity;
import com.pizzaria_springboot.pizzaria.adress.AdressModel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
	private String userName;
	private String password;
	private String name;
	private boolean admin;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<AdressModel> adresses;
}
