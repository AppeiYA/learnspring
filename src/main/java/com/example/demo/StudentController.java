package com.example.demo;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	private final StudentRepository repository;
	
	public StudentController(StudentRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/students")
	@ResponseStatus(HttpStatus.CREATED)
	public AppDtos.StudentResponseDto post(@RequestBody AppDtos.StudentDto payload) {
		var student = toStudent(payload);
		return toStudentResponse(repository.save(student));
	}
	
//	turn dto to Student object
	private Student toStudent(AppDtos.StudentDto dto) {
		var student = new Student();
		student.setFirstname(dto.firstname());
		student.setLastname(dto.lastname());
		student.setEmail(dto.email());
		
		var school = new School();
		school.setId(dto.schoolId());
		
		student.setSchool(school);
		
		return student;
	}
	
//	turn Student object to student response dto
	private AppDtos.StudentResponseDto toStudentResponse(Student student){
		return new AppDtos.StudentResponseDto(
				student.getFirstname(), 
				student.getLastname(), 
				student.getEmail()
				);
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
