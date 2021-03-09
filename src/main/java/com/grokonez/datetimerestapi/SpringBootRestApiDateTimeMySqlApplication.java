package com.grokonez.datetimerestapi;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApiDateTimeMySqlApplication {

	public static void main(String[] args) {
		
		TimeZone tz = Calendar.getInstance().getTimeZone();
		System.out.println(tz.getID()); // (i.e. Europe/Moscow)

		SpringApplication.run(SpringBootRestApiDateTimeMySqlApplication.class, args);
	}

}
