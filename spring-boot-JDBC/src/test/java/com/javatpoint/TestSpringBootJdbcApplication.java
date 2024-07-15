package com.javatpoint;

import org.springframework.boot.SpringApplication;

public class TestSpringBootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootJdbcApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
