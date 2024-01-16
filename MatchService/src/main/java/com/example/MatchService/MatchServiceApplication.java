package com.example.MatchService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class MatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchServiceApplication.class, args);
	}

}
