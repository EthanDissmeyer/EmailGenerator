package com.emailgenerator.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "clients",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "contactRef")
    }
)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;  // internal Id

    @Column(unique = true, nullable = false)
    private String contactRef;  // visible unique reference - "CL9223"

    private String contactType;        // Domestic or Commercial
    private String contactDetailType;  // Person or Organisation

    // Domestic fields
    private String firstName;
    private String lastName;

    // Commercial fields
    private String name;
    private String contactPersonName;

    @Column(unique = true)
    private String email;

    // Getters and Setters
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getContactRef() {
        return contactRef;
    }

    public void setContactRef(String contactRef) {
        this.contactRef = contactRef;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactDetailType() {
        return contactDetailType;
    }

    public void setContactDetailType(String contactDetailType) {
        this.contactDetailType = contactDetailType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
