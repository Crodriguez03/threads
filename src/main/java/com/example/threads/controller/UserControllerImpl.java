package com.example.threads.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.threads.dto.UserDTO;
import com.example.threads.service.ThreadService;

@RestController
@RequestMapping(value = "/threads")
public class UserControllerImpl implements UserController {
	
	private final ThreadService userService;
	
	public UserControllerImpl(ThreadService userService) {
		this.userService = userService;
	}

	@Override
	@GetMapping("dynamic")
	public String dynamicPool() {
		userService.dynamicPool(generateCollection(10));
		return "OK";
	}
	
	@Override
	@GetMapping("share")
	public String sharePool() {
		userService.sharePool(generateCollection(10));
		return "OK";
	}
	
	@Override
	@GetMapping("parallel-stream")
	public String parallelStream() {
		userService.parallelStream(generateCollection(11));
		return "OK";
	}
	
	private Collection<UserDTO> generateCollection(int n) {
		List<UserDTO> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(new UserDTO(i, "name_" + i, "surname" + i));
		}
		return list;
	}
	
}
