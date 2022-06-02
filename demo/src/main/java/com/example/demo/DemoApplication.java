package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = Logger.getLogger(DemoApplication.class.getName());
	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
		LogManager.getLogManager().readConfiguration();
		logger.info("REST API Started!");
	}

}
