package com.example.utp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.utp1")
public class Utp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Utp1Application.class, args);
	}

}
