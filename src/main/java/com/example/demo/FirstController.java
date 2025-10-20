package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

//	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from the first controller";
	}
	
	@PostMapping("/post")
	public String post(@RequestBody String message) {
		return "Request accepted : " + message;
	}

}
