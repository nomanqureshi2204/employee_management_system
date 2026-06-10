package com.ems.dashboard.dto;

public class AdminOverviewDto {
	
	private Long totalEmployees;
	private Long totalProjects;
	private Long totalClients;
	
	public AdminOverviewDto() {
		super();
	}

	public AdminOverviewDto(Long totalEmployees, Long totalProjects, Long totalClients) {
		super();
		this.totalEmployees = totalEmployees;
		this.totalProjects = totalProjects;
		this.totalClients = totalClients;
	}

	public Long getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(Long totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public Long getTotalProjects() {
		return totalProjects;
	}

	public void setTotalProjects(Long totalProjects) {
		this.totalProjects = totalProjects;
	}

	public Long getTotalClients() {
		return totalClients;
	}

	public void setTotalClients(Long totalClients) {
		this.totalClients = totalClients;
	}
	
	
}
