package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, UUID> {
	List<Student> findAllByFirstnameContaining(String firstname);
	List<Student> findAllByAge(Integer age);
}
