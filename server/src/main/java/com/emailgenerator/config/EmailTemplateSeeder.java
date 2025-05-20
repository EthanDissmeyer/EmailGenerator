package com.emailgenerator.config;

import com.emailgenerator.model.EmailTemplate;
import com.emailgenerator.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EmailTemplateSeeder {

    private final EmailTemplateRepository repository;

    @Autowired
    public EmailTemplateSeeder(EmailTemplateRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void seed() {
        // Skip if already seeded
        if (repository.count() > 0) {
            return;
        }

        EmailTemplate template = new EmailTemplate();
        template.setName("New Business Nature and Scope");
        template.setSubject("Our next steps for your Insurance Cover");
        template.setTransactionType("New Client");

        String body = """
            It was great to speak to/meet you today/yesterday/date to discuss your insurance needs. We believe in creating a fantastic client experience and will work tirelessly to provide personal service and quality advice for you.

            Before we progress to finding the best insurance cover for you, it is important for me to outline our next steps and present you with our Terms of Business. [Attach Terms of Business]

            This sets out how we will work on your behalf to help ensure you have the right insurance cover in place. It also contains information about how we are remunerated, your obligations and responsibilities and other aspects of our prospective relationship.

            As a Financial Advisor, I am authorised to provide advice on behalf of Rothbury Insurance Brokers and if you accept our Terms of Business, I will act as your Insurance Broker to find the right insurance cover for you.

            Following our conversation, I have included a list of the policy types I will provide you financial advice on:

            · List Policy Types you are giving advice on here.

            ** Delete if No limitations**

            I also mentioned there are some aspects that I cannot provide you with advice on. These are:

            · List Limitations here.

            ------------------------------------------ You can find more about our insurer partners and the products we provide advice on here.

            In case you have any questions or would like to discuss any changes to your insurance needs, my contact information is attached. [Attach Your Service Team]

            I look forward to working with you and will be in touch with my recommendations shortly.
            """;

        template.setBody(body);

        repository.save(template);
    }
}
