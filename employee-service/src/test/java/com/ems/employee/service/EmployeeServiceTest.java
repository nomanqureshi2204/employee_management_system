package com.ems.employee.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ems.employee.dto.EmployeeRequestDto;
import com.ems.employee.dto.EmployeeResponseDto;
import com.ems.employee.entity.Employee;
import com.ems.employee.exception.EmployeeAlreadyExistsException;
import com.ems.employee.feign.AuthFeignClient;
import com.ems.employee.feign.ProjectFeignClient;
import com.ems.employee.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository;

    @Mock
    private ProjectFeignClient projectFeignClient;

    @Mock
    private AuthFeignClient authFeignClient;

    @Test
    void testGetEmployeeByEmployeeId() {

        Employee employee = new Employee();
        employee.setEmployeeId("JTC-001");
        employee.setEmployeeName("Noman");

        when(repository.findByEmployeeId("JTC-001"))
                .thenReturn(Optional.of(employee));

        EmployeeResponseDto response =
                service.getEmployeeByEmployeeId("JTC-001");

        assertEquals("JTC-001",
                response.getEmployeeId());
    }

    @Test
    void testAddEmployee_EmailAlreadyExists() {

        EmployeeRequestDto dto = new EmployeeRequestDto();
        dto.setEmployeeEmail("test@gmail.com");

        when(repository.existsByEmployeeEmail(
                "test@gmail.com"))
                .thenReturn(true);

        assertThrows(
                EmployeeAlreadyExistsException.class,
                () -> service.addEmployee(dto));
    }

    @Test
    void testTotalEmployees() {

        when(repository.count()).thenReturn(10L);

        long total = service.getTotalEmployees();

        assertEquals(10L, total);
    }
}