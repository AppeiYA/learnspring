package com.example.demo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="t_student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	@Column(
			name="f_name",
			length=20
			)
	private String firstname;
	private String lastname;
	@Column(unique=true, nullable=false)
	private String email;
	private int age;
	
	public Student() {
	}

	public Student(String firstname, String lastname, String email, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
