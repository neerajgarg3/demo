package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;

public class TestUtil {
	
	public static List<User> generateDummyUsers(int count){
		
		if(count<1) {
			return new ArrayList<User>();
		}
		return IntStream.range(1, count + 1)
				.mapToObj(i -> generateDummyUser(i))
				.collect(Collectors.toList());
	}
	
	public static List<User> generateDummyUsersWithPosts(int userCount, int userPostsCount){
		
		List<User> users = generateDummyUsers(userCount);
		users.forEach(user-> user.setPosts(generateDummyPosts(user,userPostsCount)));
		return users;
	}

	public static List<Post> generateDummyPosts(List<User> users, int count){
		List<Post> posts=new ArrayList<>();
		if(count<1) {
			return new ArrayList<Post>();
		}
		
		users.forEach(u->posts.addAll(generateDummyPosts(u,count)));
		
		return posts;
	}

	public static List<Post> generateDummyPosts(User user, int count){
		if(count<1) {
			return new ArrayList<Post>();
		}
		
		List<Post> userPosts = IntStream.range(1, count + 1)
			.mapToObj(i -> generateDummyPost(user.getId(),i))
			.collect(Collectors.toList());
		
		
		return userPosts;
	}
	
	private static User generateDummyUser(int id) {
		User user = new User();
		user.setId(Long.valueOf(id));
		return user;
	}
	
	private static Post generateDummyPost(Long userId, int id) {
		Post post = new Post();
		post.setUserId(userId);
		post.setId(Long.valueOf(id));
		return post;
	}
}
