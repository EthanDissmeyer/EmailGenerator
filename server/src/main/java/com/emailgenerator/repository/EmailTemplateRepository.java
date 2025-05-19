package com.emailgenerator.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.emailgenerator.model.EmailTemplate;

public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
    List<EmailTemplate> findByTransactionType(String transactionType);
}
