package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class SchoolController {
	
	private final SchoolRepository schoolrepository;

	public SchoolController(SchoolRepository schoolrepository) {
		this.schoolrepository = schoolrepository;
	}

	@PostMapping("/schools")
	public School create(
			@RequestBody School school
			) {
		return schoolrepository.save(school);
	}
	@GetMapping("/schools")
	public List<School> getSchools(){
		return schoolrepository.findAll();
	}
}
