package com.honeybridge.confiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiq extends WebSecurityConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		System.out.println("Bcypt!!!!!!!");
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Bean
	public String message() {
		System.out.println("Bean message!!!!!!!");
		String message = "Hii bean massge";
		return message;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Configure!!!!!!!!!");
		http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().formLogin().permitAll().and().logout()
				.permitAll();
	}

}
