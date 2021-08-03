package com.exercise.nosunsetservice.dtos;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SunsetTimeDto {

	private ZonedDateTime sunset;

	public ZonedDateTime getSunset() {
		return sunset;
	}

	public void setSunset(ZonedDateTime sunset) {
		this.sunset = sunset;
	}
	
	
	
}
