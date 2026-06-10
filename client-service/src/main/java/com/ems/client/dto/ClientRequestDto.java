package com.ems.client.dto;

import java.util.List;

import com.ems.client.entity.ContactPerson;

public class ClientRequestDto {

    private String clientName;

    private String email;

    // multiple contact persons
    private List<ContactPerson> contacts;

    // project ids from project-service
    private List<String> projectIds;

    // getters & setters

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ContactPerson> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactPerson> contacts) {
        this.contacts = contacts;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
    }
}