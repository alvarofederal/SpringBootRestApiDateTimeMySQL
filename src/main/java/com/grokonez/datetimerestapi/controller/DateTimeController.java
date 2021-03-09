package com.grokonez.datetimerestapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.datetimerestapi.model.DateTimeModel;
import com.grokonez.datetimerestapi.repository.DateTimeRepository;

@RestController
@RequestMapping("/api")
public class DateTimeController {
	
	@Autowired
	DateTimeRepository dateTimeRepository;
	
	@GetMapping("/getdatetime")
	public Iterable<DateTimeModel> getDateTimeModel() {
		return dateTimeRepository.findAll();
	}
	
	@PostMapping("/postdatetime")
	public String postDateTimeMode(@RequestBody DateTimeModel datetime) {
		dateTimeRepository.save(datetime);
		return "Done!";
	}
	
	@GetMapping("/getallbydatetimebetween")
	public List<DateTimeModel> getAllByDatetimeBetween(
			@RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date enddate) {
		
		return dateTimeRepository.findAllByDatetimeBetween(startdate, enddate);
	}
	
	@GetMapping("/getallwithdatetimebefore")
	public List<DateTimeModel> getAllWithDatetimeBefore(
			@RequestParam("datetime") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date datetime){

		return dateTimeRepository.findAllWithDatetimeBefore(datetime);
	}
}