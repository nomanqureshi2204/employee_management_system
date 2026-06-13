package com.ems.dashboard.dto;



import java.time.LocalDate;
import java.util.List;



public class ClientResponseDto {

    private String clientId;

    private String clientName;

    private String email;

    private LocalDate relationshipDate;

    

    public ClientResponseDto() {
    }

    // constructor
    public ClientResponseDto(
            String clientId,
            String clientName,
            String email,
            LocalDate relationshipDate
        
           ) {

        this.clientId = clientId;
        this.clientName = clientName;
        this.email = email;
        this.relationshipDate = relationshipDate;
     
    
    }

    // getters & setters

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

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

    public LocalDate getRelationshipDate() {
        return relationshipDate;
    }

    public void setRelationshipDate(LocalDate relationshipDate) {
        this.relationshipDate = relationshipDate;
    }

  

   
}