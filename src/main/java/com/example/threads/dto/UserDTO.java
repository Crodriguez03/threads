package com.example.threads.dto;

public class UserDTO {
	
	private final Integer id;
	private final String name;
	private final String surname;
	
	public UserDTO(Integer id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
}
