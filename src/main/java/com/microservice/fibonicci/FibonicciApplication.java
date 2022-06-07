package com.microservice.fibonicci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FibonicciApplication {

	public static void main(String[] args) {
		SpringApplication.run(FibonicciApplication.class, args);
	}

}