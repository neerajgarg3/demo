package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long userId;
	
	private String title;
	
	private String body;
}
