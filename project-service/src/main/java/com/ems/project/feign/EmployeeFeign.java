package com.ems.project.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.project.dto.EmployeeResponseDto;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeFeign {
	
	@GetMapping("/employees/project/{projectId}")
	List<EmployeeResponseDto>
	getEmployeesByProjectId(@PathVariable String projectId);
}












