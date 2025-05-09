package com.emailgenerator.config;

import com.emailgenerator.model.Client;
import com.emailgenerator.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedClients(ClientRepository clientRepository) {
        return args -> {
            if (clientRepository.count() == 0) {
                Client c1 = new Client();
                c1.setContactRef("CL1001");
                c1.setContactType("commercial");
                c1.setContactDetailType("organisation");
                c1.setName("Red Corp");
                c1.setContactPersonName("John Manager");
                c1.setEmail("contact@red.com");

                Client c2 = new Client();
                c2.setContactRef("CL1002");
                c2.setContactType("domestic");
                c2.setContactDetailType("person");
                c2.setFirstName("Jane");
                c2.setLastName("Doe");
                c2.setEmail("jane.doe@mail.com");

                Client c3 = new Client();
                c3.setContactRef("CL1003");
                c3.setContactType("commercial");
                c3.setContactDetailType("organisation");
                c3.setName("Globex Industries");
                c3.setContactPersonName("Alice Director");
                c3.setEmail("alice@globex.com");

                Client c4 = new Client();
                c4.setContactRef("CL1004");
                c4.setContactType("domestic");
                c4.setContactDetailType("person");
                c4.setFirstName("Bob");
                c4.setLastName("Smith");
                c4.setEmail("bob.smith@mail.com");

                Client c5 = new Client();
                c5.setContactRef("CL1005");
                c5.setContactType("commercial");
                c5.setContactDetailType("organisation");
                c5.setName("Initech Solutions");
                c5.setContactPersonName("Carol Ops");
                c5.setEmail("ops@initech.com");

                Client c6 = new Client();
                c6.setContactRef("CL1006");
                c6.setContactType("domestic");
                c6.setContactDetailType("person");
                c6.setFirstName("Dave");
                c6.setLastName("Johnson");
                c6.setEmail("dave.johnson@mail.com");

                clientRepository.save(c1);
                clientRepository.save(c2);
                clientRepository.save(c3);
                clientRepository.save(c4);
                clientRepository.save(c5);
                clientRepository.save(c6);

                System.out.println("Seeded 6 initial client records.");
            } else {
                System.out.println("Clients already exist. Skipping seeding.");
            }
        };
    }
}
