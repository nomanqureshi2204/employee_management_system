package com.ems.client.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.client.dto.ProjectResponseDto;

@FeignClient(name = "PROJECT-SERVICE")
public interface ProjectFeign {
	
	@GetMapping("/projects/client/{clientId}")
	List<ProjectResponseDto>getProjectByClientId(@PathVariable String clientId);
}
