package com.ems.dashboard.dto;

public class EmployeeDashboardDto {
	
	private EmployeeResponseDto employee;
	private ProjectResponseDto project;
	
	public EmployeeDashboardDto() {}

	public EmployeeResponseDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeResponseDto employee) {
		this.employee = employee;
	}

	public ProjectResponseDto getProject() {
		return project;
	}

	public void setProject(ProjectResponseDto project) {
		this.project = project;
	}
	
	
}
