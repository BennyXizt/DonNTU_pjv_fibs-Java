package com.studentbd.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.studentbd.core.service", "com.studentbd.core.repos", "com.studentbd.core.controllers"})
@EnableJpaRepositories("com.studentbd.core.repos")
@SpringBootApplication
public class CoreApplication {


	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}
}