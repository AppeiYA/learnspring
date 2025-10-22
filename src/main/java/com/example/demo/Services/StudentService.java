package com.example.demo.Services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.AppDtos;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository repository;
	private final StudentMapper studentMapper;
	
	public StudentService(StudentRepository repository, StudentMapper studentMapper) {
		this.repository = repository;
		this.studentMapper = studentMapper;
	}
	
//	save student
	public AppDtos.StudentResponseDto saveStudent(AppDtos.StudentDto payload) {
		var student = studentMapper.toStudent(payload);
		return studentMapper.toStudentResponse(repository.save(student));
	}
	
//	get students
	public List<AppDtos.StudentResponseDto> getStudents(
			Integer age,
			String firstname
			){
		if(age != null) {
			return  repository.findAllByAge(age).stream()
					.map(student -> studentMapper.toStudentResponse(student))
					.collect(Collectors.toList());
		}
		if(firstname != null) {
			return repository.findAllByFirstnameContaining(firstname).stream()
					.map(student -> studentMapper.toStudentResponse(student))
					.collect(Collectors.toList());
		}
		return repository.findAll().stream()
				.map(student -> studentMapper.toStudentResponse(student))
				.collect(Collectors.toList());
	}
	
//	get students by firstname
	public List<AppDtos.StudentResponseDto> getStudentByFirstName(String firstname){
		return repository.findAllByFirstnameContaining(firstname).stream()
				.map(student -> studentMapper.toStudentResponse(student))
				.collect(Collectors.toList());
	}
	
//	get student by Id
	public AppDtos.StudentResponseDto getStudentById(UUID studentId){
		return studentMapper.toStudentResponse(repository.findById(studentId).orElse(new Student()));
	}
	
//	delete student
	public void deleteStudent(UUID studentId) {
		repository.deleteById(studentId);
	}
}
