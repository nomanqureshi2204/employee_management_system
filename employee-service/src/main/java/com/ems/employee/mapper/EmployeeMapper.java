package com.ems.employee.mapper;

import com.ems.employee.dto.EmployeeResponseDto;
import com.ems.employee.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeResponseDto toDto(Employee employee) {
		
		return new EmployeeResponseDto(
				employee.getEmployeeId(),
				employee.getEmployeeName(),
				employee.getEmployeeDept(),
				employee.getEmployeeEmail(),
                employee.getEmployeePhone(),
                employee.getDateOfJoining(),
                employee.getProjectId()
				);
	}
}













