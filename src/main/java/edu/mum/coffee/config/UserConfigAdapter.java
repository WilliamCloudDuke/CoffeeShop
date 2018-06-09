package edu.mum.coffee.config;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;

public class UserConfigAdapter implements UserDetails, Serializable {
	private static final long serialVersionUID = -1360188483928178893L;
	private User user;
	private Person person;

	public UserConfigAdapter(User user) {
		super();
		this.user = user;
	}

	public UserConfigAdapter(User user, Person person) {
		super();
		this.user = user;
		this.person = person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		user.getRoles().stream().forEach(authorities::add);
		return authorities;
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
		return user.isEnabled();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	
	public User getUser() {
		return user;
	}

	public Person getPerson() {
		return person;
	}
}