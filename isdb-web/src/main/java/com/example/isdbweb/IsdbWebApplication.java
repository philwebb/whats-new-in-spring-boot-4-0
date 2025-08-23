package com.example.isdbweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

@SpringBootApplication
@ImportHttpServices(group = "stuffie", types = StuffieHttpClient.class)
public class IsdbWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsdbWebApplication.class, args);
	}

}
