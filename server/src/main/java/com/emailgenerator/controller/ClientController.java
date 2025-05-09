package com.emailgenerator.controller;

import com.emailgenerator.model.Client;
import com.emailgenerator.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * returns all clients 
     */
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    /**
     * search clients by partial name or contact reference
     *
     * @param query user input
     * @return list of matching clients
     */
    @GetMapping("/search")
    public List<Client> searchClients(@RequestParam String query) {
        return clientService.searchClients(query);
    }
}
