package com.example.demo;

import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {

	@Bean
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("King Appei");
	}

}
