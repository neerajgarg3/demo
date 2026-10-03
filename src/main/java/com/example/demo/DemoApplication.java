package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		sonarTest();
		SpringApplication.run(DemoApplication.class, args);
	}

	 public static void sonarTest() {
        String password = "admin123";
        int unused = 42;
        System.out.println("debug");
        try { Integer.parseInt("abc"); } catch (Exception e) { }
    }
}
