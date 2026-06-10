package com.ems.dashboard.dto;

import java.time.LocalDate;

public class EmployeeResponseDto {

    private String employeeId;
    private String employeeName;
    private String employeeDept;
    private String employeeEmail;
    private String employeePhone;
    private LocalDate dateOfJoining;
    private String projectId;

    public EmployeeResponseDto() {
    }

    public EmployeeResponseDto(String employeeId,
                               String employeeName,
                               String employeeDept,
                               String employeeEmail,
                               String employeePhone,
                               LocalDate dateOfJoining,
                               String projectId) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDept = employeeDept;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.dateOfJoining = dateOfJoining;
        this.projectId = projectId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}