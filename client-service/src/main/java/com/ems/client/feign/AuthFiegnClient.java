package com.ems.client.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ems.client.dto.CreateUserRequest;

@FeignClient(name="AUTH-SERVICE")
public interface AuthFiegnClient {
	
	@PostMapping("/auth/internal/create-user")
	String createUser(@RequestBody CreateUserRequest request);
}
