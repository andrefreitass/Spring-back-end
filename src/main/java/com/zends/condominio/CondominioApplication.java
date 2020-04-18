package com.zends.condominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CondominioApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CondominioApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CondominioApplication.class);
	}
	
}

@RestController
class GreetingController {

	@RequestMapping("/hello")
	String hello( ) {
		return "Hello world!";
	}
}