package com.SpringSecurtyJDBC.SpringSecurtyJDBC;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig   extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		super.configure(auth);
		
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password("4323")
//			.roles("USER")
//			.and()
//			.withUser("Admin")
//			.password("34223")
//			.roles("Admin");
			//data base
		auth.jdbcAuthentication()
		.dataSource(dataSource);
		//default schema
//		.withDefaultSchema()
//		.withUser(
//				User.withUsername("user")
//				.password("pass")
//				.roles("USER")
//		)		
//		.withUser(
//				User.withUsername("admin")
//				.password("pass")
//				.roles("ADMIN")
//				);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("ADMIN","USER")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}

