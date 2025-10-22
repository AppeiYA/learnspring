package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.AppDtos;
import com.example.demo.models.School;

@Service
public class SchoolMapper {
	public AppDtos.SchoolDto toSchoolDto(School school){
		return new AppDtos.SchoolDto(school.getName());
	}
}
