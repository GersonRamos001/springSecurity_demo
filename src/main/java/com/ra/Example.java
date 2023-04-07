package com.ra;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example {
	
	@GetMapping("/")
	public String publicPage() {
		return "hello World";
	}
	
	@GetMapping("/private")
	public String privatePage(Authentication authentication) {
		return "Welcome " + authentication.getName();
	}

}
