package com.thornBird.scProduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
public class ScProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScProductApplication.class, args);
	}

}
