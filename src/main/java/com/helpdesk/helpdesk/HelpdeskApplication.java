package com.helpdesk.helpdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class HelpdeskApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelpdeskApplication.class, args);
		System.out.println("Backend is running!!");


	}

}
