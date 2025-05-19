package com.emailgenerator.controller;

import com.emailgenerator.model.EmailTemplate;
import com.emailgenerator.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class EmailTemplateController {
    private final EmailTemplateService service;

    @Autowired
    public EmailTemplateController(EmailTemplateService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmailTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }

    @GetMapping("/transaction-type/{transactionType}")
    public List<EmailTemplate> getTemplatesByTransactionType(@PathVariable String transactionType) {
        return service.getTemplatesByTransactionType(transactionType);
    }
}
