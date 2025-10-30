package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com.dev")
//@EnableJpaRepositories(basePackages = "com.dev.entity")
//@EntityScan(basePackages = "com.dev")
public class ServerMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMainApplication.class, args);
	}

}

