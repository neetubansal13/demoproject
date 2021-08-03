package com.exercise.nosunsetservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.exercise.nosunsetservice.exceptions.SunsetServiceException;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(SunsetServiceException.class)
	public ResponseEntity<Object> noServiceException(SunsetServiceException sunsetException) {
		return ResponseEntity.internalServerError().body(sunsetException.getMessage());
	}
	
}
