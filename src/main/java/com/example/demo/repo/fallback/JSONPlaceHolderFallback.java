package com.example.demo.repo.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import com.example.demo.repo.JSONPlaceHolderClient;

@Component
public class JSONPlaceHolderFallback implements JSONPlaceHolderClient{

	@Override
	public List<User> getUsers() {
		
		return new ArrayList<>();
	}

	@Override
	public List<Post> getPosts() {
		return new ArrayList<>();
	}

	
}
