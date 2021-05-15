package com.SecurityAdminDefaultLogIn.SecurityAdminDefaultLogIn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String hello()
	{	
		return "Welcome";
	}
	@GetMapping("/user")
	public String user()
	{	
		return "Welcome user";
	}
	@GetMapping("/admin")
	public String admin()
	{	
		return "Welcome Admin";
	}
	

}
