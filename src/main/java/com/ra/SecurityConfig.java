package com.ra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.authorizeRequests(
						authorizeConfig ->{
							authorizeConfig.antMatchers("/").permitAll();
							authorizeConfig.antMatchers("/error").permitAll();
							authorizeConfig.anyRequest().authenticated();
						})
						.formLogin(withDefaults())
						.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.builder()
				.username("user")
				.password("{noop}pass")
				.authorities("ROLE_user")
				.build()
	
		);
	}
	
}
