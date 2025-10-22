package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.AppDtos;
import com.example.demo.models.School;
import com.example.demo.models.Student;

@Service
public class StudentMapper {

//	turn dto to Student object
	public Student toStudent(AppDtos.StudentDto dto) {
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
	public AppDtos.StudentResponseDto toStudentResponse(Student student){
		return new AppDtos.StudentResponseDto(
				student.getFirstname(), 
				student.getLastname(), 
				student.getEmail()
				);
	}
	
}
