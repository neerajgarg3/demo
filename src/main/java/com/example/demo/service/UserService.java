package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.User;

public interface UserService {

	List<User> getUsers(boolean includePosts);
}
