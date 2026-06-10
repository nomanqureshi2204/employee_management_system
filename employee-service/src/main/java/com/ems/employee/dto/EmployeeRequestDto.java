package com.ems.employee.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmployeeRequestDto {
	
	@NotBlank(message = "Employee name is required")
	private String employeeName;
	
	@NotBlank(message="Department is required")
	private String employeeDept;
	
	@Email(message = "Invalid email")
	private String employeeEmail;

	@NotBlank(message = "Phone number is required")
	private String employeePhone;
	
	public EmployeeRequestDto() {}
	
	public EmployeeRequestDto(String employeeName,
			String employeeDept,
			String employeeEmail,
			String employeePhone){

		this.employeeName = employeeName;
		this.employeeDept = employeeDept;
		this.employeeEmail = employeeEmail;
		this.employeePhone = employeePhone;
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
	
	
	
}
