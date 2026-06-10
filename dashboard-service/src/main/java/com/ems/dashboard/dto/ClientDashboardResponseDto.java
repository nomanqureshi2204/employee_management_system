package com.ems.dashboard.dto;

import java.util.List;

public  class ClientDashboardResponseDto{
	private String clientId;
	private String clientName;
	private String email;
	
	private List<ProjectWithEmployeeDto>projects;
	
	public ClientDashboardResponseDto() {}

	public ClientDashboardResponseDto(String clientId, String clientName, String email, List<ProjectWithEmployeeDto> projects) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.email = email;
		this.projects = projects;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ProjectWithEmployeeDto> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectWithEmployeeDto> projects) {
		this.projects = projects;
	}
	
	
}