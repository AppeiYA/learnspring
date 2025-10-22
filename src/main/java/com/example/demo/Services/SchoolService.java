package com.example.demo.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.AppDtos;
import com.example.demo.models.School;
import com.example.demo.repositories.SchoolRepository;

@Service
public class SchoolService {
	private final SchoolRepository schoolrepository;
	private final SchoolMapper schoolMapper;
	
	public SchoolService(SchoolRepository schoolrepository, SchoolMapper schoolMapper) {
		this.schoolrepository = schoolrepository;
		this.schoolMapper = schoolMapper;
	}
	
	public AppDtos.SchoolDto createSchool(
			AppDtos.SchoolDto dto
			){
		var school = new School(dto.name());
		schoolrepository.save(school);
		return dto;
	}
	
	public List<AppDtos.SchoolDto> getSchools(){
		return schoolrepository.findAll().stream()
				.map(schoolMapper::toSchoolDto)
				.collect(Collectors.toList());
	}
	
}
