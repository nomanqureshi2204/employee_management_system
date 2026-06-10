package com.ems.client.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactPerson {

    private String name;
    private String email;
    private String phone;
    private String designation;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
}