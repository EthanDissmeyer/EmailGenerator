package com.emailgenerator.service;

import com.emailgenerator.model.Client;
import com.emailgenerator.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    private ClientRepository clientRepository;
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        clientService = new ClientService(clientRepository);
    }

    @Test
    void searchClients_ReturnsMatchingClients() {
        Client mockClient = new Client();
        mockClient.setContactRef("CL1234");
        mockClient.setName("Acme Corp");

        when(clientRepository.findByPartialNameOrContactRefMatch("Acme"))
            .thenReturn(List.of(mockClient));

        List<Client> result = clientService.searchClients("Acme");

        assertEquals(1, result.size());
        assertEquals("Acme Corp", result.get(0).getName());

        verify(clientRepository, times(1)).findByPartialNameOrContactRefMatch("Acme");
    }

    @Test
    void searchClients_ReturnsEmptyListWhenNoMatch() {
        when(clientRepository.findByPartialNameOrContactRefMatch("NonExisting"))
            .thenReturn(Collections.emptyList());

        List<Client> result = clientService.searchClients("NonExisting");

        assertEquals(0, result.size());
        verify(clientRepository, times(1)).findByPartialNameOrContactRefMatch("NonExisting");
    }
}
