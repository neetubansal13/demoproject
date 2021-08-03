package com.exercise.nosunsetservice.dtos;

public class PostcodeApiResponse {

	private int status;
	private LatLongDto[] result;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LatLongDto[] getResult() {
		return result;
	}
	public void setResult(LatLongDto[] result) {
		this.result = result;
	}
	
	
}
