package com.vsolu.restfuljpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootApiJpaSimpleApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringBootApiJpaSimpleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiJpaSimpleApplication.class, args);
	
	}

}
