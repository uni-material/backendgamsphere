package com.example.empanada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.empanada")
public class EmpanadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpanadaApplication.class, args);
	}

}
