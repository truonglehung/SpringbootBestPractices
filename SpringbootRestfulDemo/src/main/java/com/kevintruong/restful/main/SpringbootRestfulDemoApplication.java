package com.kevintruong.restful.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kevintruong.restful.controller","com.kevintruong.restful.dao"})
//same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringbootRestfulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulDemoApplication.class, args);
	}

}
