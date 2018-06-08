package edu.mum.coffee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String REALM = "COFFESHOP";

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/login").permitAll();

		// For products
		http.authorizeRequests().antMatchers("/products/**", "/product/**").hasRole("ADMIN").and().httpBasic()
				.realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());

		// For persons
		http.authorizeRequests().antMatchers("/person/**", "/persons/**").hasRole("ADMIN").and().httpBasic()
				.realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());

		// For orders
		http.authorizeRequests().antMatchers("/orders/**").hasRole("ADMIN").and().httpBasic().realmName(REALM)
				.authenticationEntryPoint(getBasicAuthEntryPoint());

		http.authorizeRequests().antMatchers("/placeOrder", "/my-account").authenticated();

		http.authorizeRequests().antMatchers("/webjars*", "/css/**", "/images/**").permitAll();

		http.formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}

	@Bean
	public AuthenticationEntryPoint getBasicAuthEntryPoint() {
		return new AuthenticationEntryPoint();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

}