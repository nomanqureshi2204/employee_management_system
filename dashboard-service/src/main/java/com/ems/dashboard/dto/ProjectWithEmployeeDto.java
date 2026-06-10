package com.ems.dashboard.dto;

import java.util.List;

public class ProjectWithEmployeeDto {
	private String projectId;
	private String projectName;
	
	private List<EmployeeResponseDto>employees;
	
	public ProjectWithEmployeeDto() {}

	public ProjectWithEmployeeDto(String projectId, String projectName, List<EmployeeResponseDto> employees) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.employees = employees;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<EmployeeResponseDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeResponseDto> employees) {
		this.employees = employees;
	} 
	
	
}
