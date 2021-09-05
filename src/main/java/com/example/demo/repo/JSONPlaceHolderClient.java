package com.example.demo.repo;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.Post;
import com.example.demo.dto.User;
import com.example.demo.repo.fallback.JSONPlaceHolderFallback;

@Primary
@FeignClient(name = "json-place-holder", 
	url = "${feign.client.json-place-holder.url}",
	fallback = JSONPlaceHolderFallback.class)
public interface JSONPlaceHolderClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/users")
    List<User> getUsers();
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();
	
}
