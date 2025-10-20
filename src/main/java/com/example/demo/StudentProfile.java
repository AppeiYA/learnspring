package com.example.demo;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	private String bio;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@OneToOne
	@JoinColumn(
			name="student_id"
			)
	private Student student;
	
	
	public StudentProfile() {
	}
	
	public StudentProfile(String bio) {
		this.bio = bio;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
}
