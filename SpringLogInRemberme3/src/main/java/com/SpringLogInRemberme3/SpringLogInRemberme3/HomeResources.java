package com.SpringLogInRemberme3.SpringLogInRemberme3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeResources {
	 
		
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
