package com.example.ResearchHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.ResearchHub.Repositories")
public class ResearchHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResearchHubApplication.class, args);
	}

}
