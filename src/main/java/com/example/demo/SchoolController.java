package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
public class SchoolController {
	
	private final SchoolRepository schoolrepository;

	public SchoolController(SchoolRepository schoolrepository) {
		this.schoolrepository = schoolrepository;
	}

	@PostMapping("/schools")
	public AppDtos.SchoolDto create(
			@RequestBody AppDtos.SchoolDto dto
			) {
		var school = new School(dto.name());
		schoolrepository.save(school);
		return dto;
	}
	
	private AppDtos.SchoolDto toSchoolDto(School school){
		return new AppDtos.SchoolDto(school.getName());
	}
	
	@GetMapping("/schools")
	public List<AppDtos.SchoolDto> getSchools(){
		return schoolrepository.findAll().stream()
				.map(this::toSchoolDto)
				.collect(Collectors.toList());
	}
}
