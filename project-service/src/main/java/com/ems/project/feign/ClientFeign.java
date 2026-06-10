package com.ems.project.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.project.dto.ClientResponseDto;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientFeign {
	
	@GetMapping("/clients/exists/{clientId}")
	Boolean existsByClientId(@PathVariable String clientId);
	
	@GetMapping("/clients/{clientId}")
	ClientResponseDto getClientById(@PathVariable String clientId);
	
}
