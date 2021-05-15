package com.SecuritySpringCustomLogIn.SecuritySpringCustomLogIn;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		
		auth.inMemoryAuthentication()
		.withUser("Vachi")
		.password(getPasswordEncoder().encode("vachi122230"))
		.roles("USER")
		.and()
		.withUser("Hey")
		.password(getPasswordEncoder().encode("123"))
		.roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		
		return new BCryptPasswordEncoder();
	}
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		   .antMatchers("/admin").hasRole("ADMIN")
		   .antMatchers("/user").hasAnyRole("ADMIN","USER")
		   .antMatchers("/").permitAll()
		   .and().formLogin().and().logout().deleteCookies("JSESSIONID").and().rememberMe().key("remember");
		
		
		
	}
	
}