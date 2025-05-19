package com.emailgenerator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "email_templates")
public class EmailTemplate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //this is the letter name (New business nature and scope)
    @Column(nullable = false)
    private String name;

    //email subject (our next steps for your insurance cover)
    @Column(nullable = false)
    private String subject;

    //this holds the full template body, we will use placeholders which the brokers will edit in the website
    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    //the dropdown brokers select from
    @Column(nullable = true)
    private String transactionType;

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
