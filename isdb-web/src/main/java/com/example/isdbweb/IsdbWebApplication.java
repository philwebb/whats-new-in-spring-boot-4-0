package com.example.isdbweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.resilience.annotation.EnableResilientMethods;

@SpringBootApplication
@EnableResilientMethods
public class IsdbWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsdbWebApplication.class, args);
	}

}
