package com.example.threads.service;

import java.util.Collection;

import com.example.threads.dto.UserDTO;

public interface ThreadService {

	void dynamicPool(Collection<UserDTO> users);

	void sharePool(Collection<UserDTO> users);

	void parallelStream(Collection<UserDTO> users);

}
