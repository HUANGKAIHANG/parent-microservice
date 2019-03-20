package com.example.loginout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginoutServiceApplication.class, args);
	}

}
