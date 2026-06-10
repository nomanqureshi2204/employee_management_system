package com.ems.employee.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
}
