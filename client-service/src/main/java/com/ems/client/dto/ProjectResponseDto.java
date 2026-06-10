package com.ems.client.dto;



import java.time.LocalDate;

public class ProjectResponseDto {

    private String projectId;
    private String projectName;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private String clientId;

    public ProjectResponseDto() {}

    public ProjectResponseDto(String projectId, String projectName,
                              LocalDate projectStartDate,
                              LocalDate projectEndDate,
                              String clientId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.clientId = clientId;
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

	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public LocalDate getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(LocalDate projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

    
}