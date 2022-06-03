package com.blogpessoal.blogpessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //vai habilitar a configuração.
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired //injeção de dependência (injeta de uma classe que já existe).
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.userDetailsService(userDetailsService);
	
}
	
	@Bean //diz ao spring que quer criar objeto e deixa-lo disponivel para outras classes.
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests() //serve para liberar os endpoints.
		.antMatchers("/usuarios/login").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}
}
