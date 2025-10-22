package com.example.demo;

import java.util.UUID;

import jakarta.validation.constraints.*;

public class AppDtos {
	
	public static record StudentDto(
			@NotEmpty(message="Firstname should not be empty")
			String firstname,
			@NotEmpty(message="Lastname should not be empty")
			String lastname,
			@Email(message="Invalid email address")
			@NotNull
			String email,
			@NotNull(message="SchoolId can not be empty or null")
			UUID schoolId
			) {
	}
	
	public static record StudentResponseDto(
			String firstname,
			String lastname,
			String email
			) {
	}
	public static record SchoolDto(
			String name
			) {}
}
