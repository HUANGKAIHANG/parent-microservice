package com.example.commodity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class CommodityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommodityServiceApplication.class, args);
	}

}
