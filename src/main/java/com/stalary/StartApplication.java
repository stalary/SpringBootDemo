package com.stalary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StartApplication.class);
		app.run(args);
	}


}
