package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnspringApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(LearnspringApplication.class, args);
		
		MyFirstService myfirstservice = ctx.getBean(MyFirstService.class);
		System.out.println(myfirstservice.tellAStory());
	}
}
