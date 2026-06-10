package com.ems.client.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;

    private String clientName;

    private String email;

    private LocalDate relationshipDate;

    // 🔥 contact persons (embedded value object)
    @ElementCollection
    @CollectionTable(
        name = "client_contacts",
        joinColumns = @JoinColumn(name = "client_id")
    )
    private List<ContactPerson> contacts;

    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<ContactPerson> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactPerson> contacts) {
		this.contacts = contacts;
	}

	

    
}