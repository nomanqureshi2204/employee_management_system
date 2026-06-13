package com.ems.dashboard.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ems.dashboard.dto.AdminOverviewDto;
import com.ems.dashboard.dto.ClientDashboardResponseDto;
import com.ems.dashboard.dto.ClientResponseDto;
import com.ems.dashboard.dto.EmployeeDashboardDto;
import com.ems.dashboard.dto.EmployeeResponseDto;
import com.ems.dashboard.dto.ProjectResponseDto;
import com.ems.dashboard.feign.ClientFeignClient;
import com.ems.dashboard.feign.EmployeeFeignClient;
import com.ems.dashboard.feign.ProjectFeignCleint;

@ExtendWith(MockitoExtension.class)
class DashboardServiceTest {

    @InjectMocks
    private DashboardService dashboardService;

    @Mock
    private EmployeeFeignClient employeeFeignClient;

    @Mock
    private ProjectFeignCleint projectFeignCleint;

    @Mock
    private ClientFeignClient clientFeignClient;

    @Test
    void testGetAdminOverview() {

        when(employeeFeignClient.getTotalEmployees())
                .thenReturn(100L);

        when(projectFeignCleint.getTotalProjects())
                .thenReturn(20L);

        when(clientFeignClient.getTotalClients())
                .thenReturn(10L);

        AdminOverviewDto result =
                dashboardService.getAdminOverview();

        assertNotNull(result);

        assertEquals(
                100L,
                result.getTotalEmployees());

        assertEquals(
                20L,
                result.getTotalProjects());

        assertEquals(
                10L,
                result.getTotalClients());
    }

    @Test
    void testGetEmployeeDashboard() {

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        "employee@gmail.com",
                        null);

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        EmployeeResponseDto employee =
                new EmployeeResponseDto();

        employee.setEmployeeId("JTC-001");

        ProjectResponseDto project =
                new ProjectResponseDto();

        project.setProjectId("project-001");
        project.setProjectName("EMS");

        when(employeeFeignClient.getEmployeeByEmail(
                "employee@gmail.com"))
                .thenReturn(employee);

        when(employeeFeignClient
                .getProjectDetailsByEmployeeId(
                        "JTC-001"))
                .thenReturn(project);

        EmployeeDashboardDto result =
                dashboardService.getEmployeeDashboard();

        assertNotNull(result);

        assertEquals(
                "JTC-001",
                result.getEmployee().getEmployeeId());

        assertEquals(
                "project-001",
                result.getProject().getProjectId());
    }

    @Test
    void testGetClientDashboard() {

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        "client@gmail.com",
                        null);

        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        ClientResponseDto client =
                new ClientResponseDto();

        client.setClientId("client-001");
        client.setClientName("ABC Client");
        client.setEmail("client@gmail.com");

        ProjectResponseDto project =
                new ProjectResponseDto();

        project.setProjectId("project-001");
        project.setProjectName("EMS");

        EmployeeResponseDto employee =
                new EmployeeResponseDto();

        employee.setEmployeeId("JTC-001");

        when(clientFeignClient.getClientByEmail(
                "client@gmail.com"))
                .thenReturn(client);

        when(projectFeignCleint.getProjectsByClientId(
                "client-001"))
                .thenReturn(List.of(project));

        when(employeeFeignClient.getEmployeesByProjectId(
                "project-001"))
                .thenReturn(List.of(employee));

        ClientDashboardResponseDto result =
                dashboardService.getClientDashboard();

        assertNotNull(result);

        assertEquals(
                "client-001",
                result.getClientId());

        assertEquals(
                "ABC Client",
                result.getClientName());

        assertEquals(
                1,
                result.getProjects().size());
    }
}