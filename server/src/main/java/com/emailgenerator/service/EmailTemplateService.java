package com.emailgenerator.service;

import com.emailgenerator.model.EmailTemplate;
import com.emailgenerator.repository.EmailTemplateRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class EmailTemplateService {
 
    private final EmailTemplateRepository repository;

    @Autowired
    public EmailTemplateService(EmailTemplateRepository repository) {
        this.repository = repository;
    }

    public List<EmailTemplate> getAllTemplates() {
        return repository.findAll();
    }

    public List<EmailTemplate> getTemplatesByTransactionType(String transactionType) {
        return repository.findByTransactionType(transactionType);
    }
}
