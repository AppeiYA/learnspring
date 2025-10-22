package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AppDtos;
import com.example.demo.Services.StudentService;

@RestController
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/students")
	@ResponseStatus(HttpStatus.CREATED)
	public AppDtos.StudentResponseDto saveStudent(@RequestBody AppDtos.StudentDto payload) {
		return this.studentService.saveStudent(payload);
	}
	
	@GetMapping("/students")
	public List<AppDtos.StudentResponseDto> getStudents(
			@RequestParam(required=false) Integer age,
			@RequestParam(required=false) String firstname
			){
		return this.studentService.getStudents(age, firstname);
	}
	
	@GetMapping("/students/search/{firstname}")
	public List<AppDtos.StudentResponseDto> findStudentsByFirstname(@PathVariable String firstname){
		return this.studentService.getStudentByFirstName(firstname);
	}
	
	@GetMapping("/students/{studentId}")
	public AppDtos.StudentResponseDto findById(@PathVariable UUID studentId) {
		return this.studentService.getStudentById(studentId);
	}
	
	@DeleteMapping("/students/{studentId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudent(@PathVariable UUID studentId) {
		this.studentService.deleteStudent(studentId);
	}

}
