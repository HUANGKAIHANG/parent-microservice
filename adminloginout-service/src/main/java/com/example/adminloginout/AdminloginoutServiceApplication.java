package com.example.adminloginout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminloginoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminloginoutServiceApplication.class, args);
	}

}
