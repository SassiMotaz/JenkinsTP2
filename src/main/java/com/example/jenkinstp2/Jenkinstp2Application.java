package com.example.jenkinstp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Jenkinstp2Application {

	public static void main(String[] args) {
		SpringApplication.run(Jenkinstp2Application.class, args);
	}

	@GetMapping("/message")
	public String getMessage() {
		return "Hello Jenkins";
	}

}
