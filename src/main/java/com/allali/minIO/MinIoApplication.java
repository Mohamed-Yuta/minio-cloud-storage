package com.allali.minIO;

import com.allali.minIO.service.MinIOService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MinIoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinIoApplication.class, args);
	}


	@Bean
	CommandLineRunner init(MinIOService minioService) {
		return args -> minioService.init();
	}
}
