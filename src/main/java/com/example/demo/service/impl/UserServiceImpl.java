package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import com.example.demo.repo.JSONPlaceHolderClient;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private JSONPlaceHolderClient jsonPlaceHolderClient;


	@Override
	public List<User> getUsers(boolean includePosts) {
		List<User> users = jsonPlaceHolderClient.getUsers();


		if(includePosts && users != null) {
			
			List<Post> posts = jsonPlaceHolderClient.getPosts();
			Map<Long, List<Post>> userPosts = posts.parallelStream()
					.collect(Collectors.groupingBy(Post :: getUserId));
			users.forEach(user -> {
				user.setPosts(userPosts.get(user.getId()));
			});
		}
		return users;
	}

}
