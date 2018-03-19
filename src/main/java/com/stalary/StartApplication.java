package com.stalary;

import com.stalary.filter.CrossOriginFilter;
import com.stalary.properties.Props;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.servlet.Filter;

@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@EnableCaching
@Import({Props.class})
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StartApplication.class);
		app.run(args);
	}

	@Bean
	public FilterRegistrationBean crossOriginFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(crossOriginFilter());
		registration.addUrlPatterns("*");
		registration.setName("crossOriginFilter");
		registration.setOrder(1);
		return registration;
	}

	@Bean(name = "crossOriginFilter")
	public Filter crossOriginFilter() {
		return new CrossOriginFilter();
	}

}
