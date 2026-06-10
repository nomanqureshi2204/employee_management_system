package com.ems.project.exception;

public class ProjectAlreadyExistsException extends RuntimeException {

    public ProjectAlreadyExistsException(String message) {
        super(message);
    }
}