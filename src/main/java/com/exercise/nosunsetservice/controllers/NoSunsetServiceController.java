package com.exercise.nosunsetservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.nosunsetservice.exceptions.SunsetServiceException;
import com.exercise.nosunsetservice.services.NoSunsetService;

@RestController
@RequestMapping("/api")
public class NoSunsetServiceController {
	
	@Autowired
	NoSunsetService noSunsetService;
	
	@GetMapping("/service1")
	public ResponseEntity<?> service1(@RequestParam("name")String name,
			@RequestParam("postcode")String postcode) throws SunsetServiceException{
	
		boolean result = noSunsetService.providingService(name, postcode);
		String message = "";
		
		if(result == false) {
			message = "Sorry "+ name+ ", you are not allowed";
			return ResponseEntity.status(HttpStatus.FORBIDDEN).
					body(message);
		}
			
		message = "Congratulations "+ name+ ", you are allowed";
				
		return ResponseEntity.ok(message);
	}
	
}
