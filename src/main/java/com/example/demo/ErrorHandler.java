package com.example.demo;

import java.util.HashMap;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exp
			){
		var errors = new HashMap<String, String>();
//		var errorMessage = "";
		var errorList = exp.getBindingResult().getAllErrors().stream()
				.map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		String errorString = String.join(", " , errorList);
//		.forEach(error -> {
////			var fieldName = ((FieldError) error).getField();
//			errorMessage += error.getDefaultMessage();
////			errors.put(fieldName, errorMessage);
//		});
		errors.put("Error", errorString);
		errors.put("StatusCode", HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

}
