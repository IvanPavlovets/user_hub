package com.webraise.subscription;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableFeignClients(basePackages = "com.webraise.subscription.service")
public class SubscrApp {

	public static void main(String[] args) {
		SpringApplication.run(SubscrApp.class, args);
		log.info("Go to -> :{}", "http://localhost:8081");
	}

}
