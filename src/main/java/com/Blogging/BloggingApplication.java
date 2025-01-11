package com.Blogging;

import org.modelmapper.ModelMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggingApplication.class, args);
		
	
	}
	@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
}
