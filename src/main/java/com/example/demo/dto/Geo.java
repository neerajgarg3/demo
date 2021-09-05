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
public class Geo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double lat;

	private double lng;

}
