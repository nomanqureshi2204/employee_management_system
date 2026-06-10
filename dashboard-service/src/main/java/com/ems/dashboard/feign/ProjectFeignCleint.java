package com.ems.dashboard.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.dashboard.dto.ProjectResponseDto;

@FeignClient(name = "PROJECT-SERVICE")
public interface ProjectFeignCleint {
	
	@GetMapping("/projects/count")
	Long getTotalProjects();
	
	@GetMapping("/projects/client/{clientId}")
	List<ProjectResponseDto>getProjectsByClientId(@PathVariable("client") String clientId);
}














