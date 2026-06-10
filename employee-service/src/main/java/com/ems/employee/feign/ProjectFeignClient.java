package com.ems.employee.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.employee.dto.ProjectResponseDto;

@FeignClient(name = "project-service")
public interface ProjectFeignClient {

	// call project service API

	@GetMapping("/projects/{projectId}")
	ProjectResponseDto getProjectById(@PathVariable String projectId);

}
