package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.dto.User;
import com.example.demo.util.TestUtil;

@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {UserController.class})
@AutoConfigureMockMvc
public class UserControllerTest {
	
	private static final int NO_OF_USERS = 5;
	private static final int NO_OF_USER_POSTS = 3;

	@Autowired
    private MockMvc mvc;

    @MockBean
    private UserController service;
    
    @BeforeEach
	public void setUp() {
    	List<User> users = TestUtil.generateDummyUsers(NO_OF_USERS);
    	List<User> usersWithPosts = TestUtil.generateDummyUsersWithPosts(NO_OF_USERS, NO_OF_USER_POSTS);
    	Mockito.when(service.getUsers(true)).thenReturn(usersWithPosts);
		Mockito.when(service.getUsers(false)).thenReturn(users);
	}
    
    @Test
    public void whenGetUsers_withIncludePostsEqFalse_thenUserShouldNotHavePosts()
      throws Exception {
        
        
        mvc.perform(get("/api/users?includePosts=false")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(NO_OF_USERS)))
        		.andExpect(MockMvcResultMatchers.jsonPath("$..posts").doesNotExist());       
    }
    
    @Test
    public void whenGetUsers_withNoIncludePosts_thenUsersShouldNotHavePosts()
      throws Exception {
        
        
        mvc.perform(get("/api/users")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(NO_OF_USERS)))
        		.andExpect(MockMvcResultMatchers.jsonPath("$..posts").doesNotExist());     
    }
    
    @Test
    public void whenGetUsers_withIncludePostsEqTrue_thenUserShouldHavePosts()
      throws Exception {
        
        mvc.perform(get("/api/users?includePosts=true")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(NO_OF_USERS)))
        		.andExpect(MockMvcResultMatchers.jsonPath("$[0].posts",Matchers.hasSize(NO_OF_USER_POSTS))); 
    }
    
}
