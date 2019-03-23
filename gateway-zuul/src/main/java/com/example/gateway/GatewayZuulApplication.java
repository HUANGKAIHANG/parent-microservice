package com.example.gateway;

import com.example.gateway.config.MyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulApplication.class, args);
	}

	@Bean
	public MyFilter myFilter() {
		return new MyFilter();
	}

}
