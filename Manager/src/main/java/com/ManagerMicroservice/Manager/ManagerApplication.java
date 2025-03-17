package com.ManagerMicroservice.Manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableWebSecurity
@Component
@SpringBootApplication
public class ManagerApplication implements CommandLineRunner {
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
