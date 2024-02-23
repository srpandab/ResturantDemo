package com.resturantDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ResturantDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResturantDemoApplication.class, args);
	}

}
