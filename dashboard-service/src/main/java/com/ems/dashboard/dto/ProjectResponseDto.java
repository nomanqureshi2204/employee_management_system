package com.ems.dashboard.dto;

public class ProjectResponseDto {

    private String projectId;
    private String projectName;
    private String clientId;

    public ProjectResponseDto() {
    }

    public ProjectResponseDto(
            String projectId,
            String projectName,
            String clientId) {

        this.projectId = projectId;
        this.projectName = projectName;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}