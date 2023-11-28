package com.pizzaria_springboot.pizzaria.features.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class UserModel implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private String name;
	private boolean admin;
	// @OneToOne
	// @JoinColumn(name = "adress_id")
	// private AdressModel adress;
	
	public UserRecordDto convertToDto() {
		UserRecordDto userRecordDto = new UserRecordDto(
			id,
			email, 
			password, 
			name, 
			admin
		);
		return userRecordDto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> rolesList = new ArrayList<>();

		if (admin == true) {
			rolesList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			rolesList.add(new SimpleGrantedAuthority("ROLE_USER"));
		} else rolesList.add(new SimpleGrantedAuthority("ROLE_USER"));

		return rolesList;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;	
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
	