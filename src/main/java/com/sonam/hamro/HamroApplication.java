package com.sonam.hamro;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HamroApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(HamroApplication.class);
		springApplication.run(args);
	}

}
