package com.ems.project.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ems.project.dto.ProjectRequestDto;
import com.ems.project.dto.ProjectResponseDto;
import com.ems.project.entity.Project;
import com.ems.project.exception.ProjectAlreadyExistsException;
import com.ems.project.feign.ClientFeign;
import com.ems.project.feign.EmployeeFeign;
import com.ems.project.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @InjectMocks
    private ProjectService service;

    @Mock
    private ProjectRepository repository;

    @Mock
    private ClientFeign clientFeign;

    @Mock
    private EmployeeFeign employeeFeign;

    @Test
    void testGetProjectById() {

        Project project = new Project();
        project.setProjectId("project-001");
        project.setProjectName("EMS");

        when(repository.findByProjectId("project-001"))
                .thenReturn(Optional.of(project));

        ProjectResponseDto response =
                service.getProjectById("project-001");

        assertEquals(
                "project-001",
                response.getProjectId());
    }

    @Test
    void testCreateProject_ProjectAlreadyExists() {

        ProjectRequestDto dto = new ProjectRequestDto();

        dto.setProjectName("EMS");
        dto.setClientId("CLIENT-001");
        dto.setProjectStartDate(LocalDate.now());
        dto.setProjectEndDate(LocalDate.now().plusMonths(6));

        when(clientFeign.existsByClientId("CLIENT-001"))
                .thenReturn(true);

        when(repository.existsByProjectName("EMS"))
                .thenReturn(true);

        assertThrows(
                ProjectAlreadyExistsException.class,
                () -> service.createProject(dto));
    }

    @Test
    void testGetTotalProjects() {

        when(repository.count()).thenReturn(5L);

        long total = service.getTotalProjects();

        assertEquals(5L, total);
    }
}