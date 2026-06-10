package com.ems.dashboard.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ems.dashboard.dto.EmployeeResponseDto;
import com.ems.dashboard.dto.ProjectResponseDto;

@FeignClient(name ="EMPLOYEE-SERVICE")
public interface EmployeeFeignClient {
	
	@GetMapping("/employees/count")
	Long getTotalEmployees();
	
	//Get Employee By Email
	@GetMapping("/employees/email/{email}")
	EmployeeResponseDto getEmployeeByEmail(@PathVariable String email);
	
	//Get Project By Employee Id 
	@GetMapping("/employees/{employeeId}/project")
	ProjectResponseDto getProjectDetailsByEmployeeId(@PathVariable String employeeId);
	
	@GetMapping("/employees/project/{projectId}")
	List<EmployeeResponseDto>getEmployeesByProjectId(@PathVariable("projectId")String projectId);
}








