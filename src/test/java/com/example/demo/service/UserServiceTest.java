package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import com.example.demo.repo.JSONPlaceHolderClient;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.util.TestUtil;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	private static final int NO_OF_USERS = 5;
	private static final int NO_OF_USER_POSTS = 3;
	
	@Mock
	private JSONPlaceHolderClient jsonPlaceholderClient;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@BeforeEach
	public void setUp() {
		List<User> users = TestUtil.generateDummyUsers(NO_OF_USERS);
		List<Post> posts = TestUtil.generateDummyPosts(users, NO_OF_USER_POSTS);
		Mockito.when(jsonPlaceholderClient.getUsers()).thenReturn(users);
		Mockito.lenient().when(jsonPlaceholderClient.getPosts()).thenReturn(posts);
	}
	
	@Test
	public void whenIncludePosts_thenUsersShouldHavePostsData() {
		List<User> result = userService.getUsers(true);
		assertThat(result).hasSize(NO_OF_USERS);
		result.forEach(user->assertThat(user.getPosts()).hasSize(NO_OF_USER_POSTS));
	}
	
	@Test
	public void whenNotIncludePosts_thenUsersShouldNotHavePostsData() {
		List<User> result = userService.getUsers(false);
		assertThat(result).hasSize(NO_OF_USERS);
		result.forEach(user->assertThat(user.getPosts()).isNull());
	}
	
	
}
