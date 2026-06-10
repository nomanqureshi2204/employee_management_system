package com.ems.employee.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.ems.employee.dto.EmployeeRequestDto;
import com.ems.employee.dto.EmployeeResponseDto;
import com.ems.employee.dto.EmployeeUpdateDto;
import com.ems.employee.dto.ProjectResponseDto;
import com.ems.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Add Employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> addEmployee(
            @Valid @RequestBody EmployeeRequestDto dto) {

        EmployeeResponseDto employee = service.addEmployee(dto);

        return ResponseEntity.ok(employee);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {

        List<EmployeeResponseDto> employees =
                service.getallEmployees();

        return ResponseEntity.ok(employees);
    }

    // Get Employee By EmployeeId
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto>
    getEmployeeByEmployeeId(
            @PathVariable String employeeId) {

        EmployeeResponseDto employee =
                service.getEmployeeByEmployeeId(employeeId);

        return ResponseEntity.ok(employee);
    }

    // Get Employee By Email
    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeResponseDto>
    getEmployeeByEmail(
            @PathVariable String email) {

        EmployeeResponseDto employee =
                service.getEmployeeByEmail(email);

        return ResponseEntity.ok(employee);
    }

    // Get Employees By Date Range
    @GetMapping("/date-range")
    public ResponseEntity<List<EmployeeResponseDto>>
    getEmployeeByDateRange(

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startDate,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate endDate) {

        List<EmployeeResponseDto> employees =
                service.getEmployeeByDateRange(
                        startDate,
                        endDate);

        return ResponseEntity.ok(employees);
    }

    // Update Employee
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto>
    updateEmployee(
            @PathVariable String employeeId,
            @Valid @RequestBody EmployeeUpdateDto dto) {

        EmployeeResponseDto employee =
                service.updateEmployee(employeeId, dto);

        return ResponseEntity.ok(employee);
    }

    // Delete Employee
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable String employeeId) {

        String message =
                service.deleteEmployee(employeeId);

        return ResponseEntity.ok(message);
    }

    // Get Bench Employees
    @GetMapping("/bench")
    public ResponseEntity<List<EmployeeResponseDto>>
    getBenchEmployees() {

        List<EmployeeResponseDto> employees =
                service.getBenchEmployee();

        return ResponseEntity.ok(employees);
    }
    
    // Get Project Details By Employee Id 
    @GetMapping("/{employeeId}/project")
    public ResponseEntity<ProjectResponseDto>getProjectDetailsByEmployeeId(
    		@PathVariable String employeeId){
    	ProjectResponseDto project = service.getProjectDetailsByEmployeeId(employeeId);
    	
    	return ResponseEntity.ok(project);
    }
    
    //Admin can onboard employee on project 
    @PutMapping("/{employeeId}/onboard/{projectId}")
    public ResponseEntity<EmployeeResponseDto>onboardEmployee(
    		@PathVariable String employeeId,
    		@PathVariable String projectId
    		){
    	EmployeeResponseDto employee = service.onboardEmployee(employeeId, projectId);
    	
    	return ResponseEntity.ok(employee);
    }
    
    // Realease Employee From Project 
    @PutMapping("/{employeeId}/release")
    public ResponseEntity<EmployeeResponseDto>releaseEmployeeFromProject(
    		@PathVariable String employeeId
    		){
    	EmployeeResponseDto employee = service.releaseEmployeeFromProject(employeeId);
    	
    	return ResponseEntity.ok(employee);
    }
    
    //Get All Employees By Project Id 
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<EmployeeResponseDto>>getEmployeeByProjectId(
    		@PathVariable String projectId
    		){
    	return ResponseEntity.ok(service.getEmployeesByProjectId(projectId));
    }
    
    // get total no of employees
    @GetMapping("/count")
    public ResponseEntity<Long>getTotalEmployees(){
    	return ResponseEntity.ok(service.getTotalEmployees());
    }
    
    
}












