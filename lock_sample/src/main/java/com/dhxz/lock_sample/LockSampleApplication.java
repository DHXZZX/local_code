package com.dhxz.lock_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LockSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LockSampleApplication.class, args);
	}
}
