package com.OwnerMicroservice.Owner;

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
public class OwnerApplication implements CommandLineRunner {
	@Bean
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OwnerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
