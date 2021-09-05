package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.UserController;
import com.example.demo.repo.JSONPlaceHolderClient;
import com.example.demo.service.UserService;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JSONPlaceHolderClient jsonPlaceHolderClient;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(userController).isNotNull();
		assertThat(userService).isNotNull();
		assertThat(jsonPlaceHolderClient).isNotNull();
	}

}
