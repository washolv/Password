package com.itau.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.itau.password")
public class PasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordApplication.class, args);
	}

}
