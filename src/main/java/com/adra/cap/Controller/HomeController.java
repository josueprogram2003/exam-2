package com.adra.cap.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String mensaje() {
		return "Estas en Spring boot";
	}
	
}
