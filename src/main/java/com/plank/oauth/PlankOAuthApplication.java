package com.plank.oauth;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class PlankOAuthApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(PlankOAuthApplication.class, args);
	}

}
