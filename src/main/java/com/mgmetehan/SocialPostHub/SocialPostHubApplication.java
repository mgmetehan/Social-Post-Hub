package com.mgmetehan.SocialPostHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SocialPostHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialPostHubApplication.class, args);
	}

}
