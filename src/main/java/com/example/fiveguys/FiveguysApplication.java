package com.example.fiveguys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiveguysApplication {
//====================================================================================================
	// when running the api Url is : http://192.168.10.130:8080/feedback
//====================================================================================================
	public static void main(String[] args) {
		System.out.println("Welcome Team FiveGuys !");
		SpringApplication.run(FiveguysApplication.class, args);
	}
}
