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
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String street;
	
	private String suite;
	
	private String city;
	
	private String zipcode;
	
	private Geo geo;
	
}