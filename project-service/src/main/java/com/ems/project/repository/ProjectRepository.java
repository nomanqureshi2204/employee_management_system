package com.ems.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    boolean existsByProjectName(String projectName);

    Optional<Project> findByProjectId(String projectId);
    
    // get the project details from the client-id
    List<Project>findByClientId(String clientId);
    
    @Query("SELECT p.projectId FROM Project p ORDER BY p.id DESC LIMIT 1 ")
    String findLastProjectId();
    
    
}