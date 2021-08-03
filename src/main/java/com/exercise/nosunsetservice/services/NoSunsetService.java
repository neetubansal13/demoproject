package com.exercise.nosunsetservice.services;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.nosunsetservice.dtos.LatLongDto;
import com.exercise.nosunsetservice.dtos.SunsetTimeDto;
import com.exercise.nosunsetservice.exceptions.SunsetServiceException;
import com.exercise.nosunsetservice.vendor.VendorService;

@Service
public class NoSunsetService {

	@Autowired
	VendorService vendorService;
	
	public boolean providingService(String name, String postcode) throws SunsetServiceException {
//		LatLongDto latLongRes = vendorService.getLatLongByPostCode(postcode);
//		SunsetTimeDto sunsetTimeRes = vendorService.getSunsetTimeByLatLong(latLongRes.getLatitude(), latLongRes.getLongitude());
//		
//		ZonedDateTime userRequested = sunsetTimeRes.getSunset();
//		
//		ZonedDateTime nowTime  = ZonedDateTime.now();
//		
//		if(nowTime.equals(userRequested) || nowTime.isAfter(userRequested))
//			return false;
		
		return true;

	}
}
