package com.exercise.nosunsetservice.vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exercise.nosunsetservice.dtos.LatLongApiResponse;
import com.exercise.nosunsetservice.dtos.LatLongDto;
import com.exercise.nosunsetservice.dtos.PostcodeApiResponse;
import com.exercise.nosunsetservice.dtos.SunsetTimeDto;
import com.exercise.nosunsetservice.exceptions.SunsetServiceException;


@Service
public class VendorService {

	@Autowired
	RestTemplate restTemplate;
	

	
	public LatLongDto getLatLongByPostCode(String postcode) throws SunsetServiceException {
		String url = VendorAPIs.POSTCODE_API+postcode;

		LatLongDto latLongRes = null;
		PostcodeApiResponse response = restTemplate.getForObject(url, PostcodeApiResponse.class);
		if(response==null || response.getStatus()!=200) {
			throw new SunsetServiceException("Vendor API for postcode is not working");
		}
		
		LatLongDto latlong[] = response.getResult();
		if(latlong.length>0) {
			latLongRes = latlong[0];
		}
		
		return latLongRes;
	}
	
	
	//getting sunset time by lat and long
	
	public SunsetTimeDto getSunsetTimeByLatLong(String latitude, String longitude) throws SunsetServiceException {
		String url = VendorAPIs.LATLONG_API.replace("{latitude}", latitude)
				.replace("{longitude}", longitude);

		SunsetTimeDto sunsetRes = null;
		
		LatLongApiResponse latlongRes = restTemplate.getForObject(url, LatLongApiResponse.class); 
	
		
		if(latlongRes ==null) {
			throw new SunsetServiceException("Vendor API for gettting Sunset Time  is not working");
		}
		
		sunsetRes = latlongRes.getResults();
		
		return sunsetRes;
		
	}
	
}
