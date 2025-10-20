package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	private final StudentRepository repository;
	
	public FirstController(StudentRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/students")
	public Student post(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@GetMapping("/students")
	public List<Student> findAll(
			@RequestParam(required=false) Integer age,
			@RequestParam(required=false) String firstname
			){
		if(age != null) {
			return repository.findAllByAge(age);
		}
		if(firstname != null) {
			return repository.findAllByFirstnameContaining(firstname);
		}
		return repository.findAll();
	}
	
	@GetMapping("/students/search/{firstname}")
	public List<Student> findStudentsByFirstname(@PathVariable String firstname){
		return repository.findAllByFirstnameContaining(firstname);
	}
	
	@GetMapping("/students/{studentId}")
	public Student findById(@PathVariable UUID studentId) {
		return repository.findById(studentId).orElse(new Student());
	}
	
	@DeleteMapping("/students/{studentId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteStudent(@PathVariable UUID studentId) {
		repository.deleteById(studentId);
	}

}
