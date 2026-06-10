package com.ems.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dashboard.dto.AdminOverviewDto;
import com.ems.dashboard.dto.ClientDashboardResponseDto;
import com.ems.dashboard.dto.EmployeeDashboardDto;
import com.ems.dashboard.service.DashboardService;


@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired 
	private DashboardService service;
	
	@GetMapping("/admin/overview")
	public ResponseEntity<AdminOverviewDto>getAdminOverview(){
		
		return ResponseEntity.ok(service.getAdminOverview());
	}
	
	// Employee Dashboard API return employee details + project details 
	@GetMapping("/employee/me")
	public ResponseEntity<EmployeeDashboardDto>getEmployeeDashboard(){
		return ResponseEntity.ok(service.getEmployeeDashboard());
	}
	
	@GetMapping("client/me")
	public ResponseEntity<ClientDashboardResponseDto> getClientDashboard() {
		 return ResponseEntity.ok(service.getClientDashboard());
	}

}










