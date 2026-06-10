package com.ems.employee.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// check duplicate email
	boolean existsByEmployeeEmail(String employeeEmail);

	// get employee by employeeId
	Optional<Employee> findByEmployeeId(String employeeId);

	// get employee by email
	Optional<Employee> findByEmployeeEmail(String employeeEmail);

	// get all bench employees
	List<Employee> findByProjectIdIsNull();
	
	// get all employees by project id 
	List<Employee>findByProjectId(String projectId);
	
	
	@Query("SELECT e.employeeId FROM Employee e ORDER BY e.id DESC LIMIT 1 ")
	String findLastEmployeeId();
	
	
	List<Employee>findByDateOfJoiningBetween(
			LocalDate startDate,
			LocalDate enddate
			);
	
	
}




