package com.example.demo;

import java.util.UUID;

public class AppDtos {
	public static record StudentDto(
			String firstname,
			String lastname,
			String email,
			UUID schoolId
			) {
		
	}
	
	public static record StudentResponseDto(
			String firstname,
			String lastname,
			String email
			) {
		
	}
}
