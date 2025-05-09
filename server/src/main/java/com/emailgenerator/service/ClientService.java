package com.emailgenerator.service;

import com.emailgenerator.model.Client;
import com.emailgenerator.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * retrieves all clients as a list.
     * used for initial dropdown population.
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * searches clients by partial name or contactRef.
     * used for autocomplete when the user starts typing.
     * @param query user-entered search text
     * @return list of matching clients
     */
    public List<Client> searchClients(String query) {
        return clientRepository.findByPartialNameOrContactRefMatch(query);
    }
}
