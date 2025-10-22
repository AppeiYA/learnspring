package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.AppDtos;
import com.example.demo.Services.SchoolService;

@RestController
public class SchoolController {
	
	private final SchoolService schoolService;

	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}


	@PostMapping("/schools")
	public AppDtos.SchoolDto create(
			@RequestBody AppDtos.SchoolDto dto
			) {
		return this.schoolService.createSchool(dto);
	}
	
	
	@GetMapping("/schools")
	public List<AppDtos.SchoolDto> getSchools(){
		return this.schoolService.getSchools();
	}
}
