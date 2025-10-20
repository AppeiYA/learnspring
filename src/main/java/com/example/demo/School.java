package com.example.demo;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class School {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	private String name;

	public School() {
	}

	public School(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
