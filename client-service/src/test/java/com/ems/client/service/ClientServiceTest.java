package com.ems.client.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ems.client.dto.ClientRequestDto;
import com.ems.client.dto.ClientResponseDto;
import com.ems.client.entity.Client;
import com.ems.client.exception.ClientAlreadyExistsException;
import com.ems.client.feign.AuthFiegnClient;
import com.ems.client.feign.ProjectFeign;
import com.ems.client.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService service;

    @Mock
    private ClientRepository repository;

    @Mock
    private ProjectFeign projectFeign;

    @Mock
    private AuthFiegnClient authFiegnClient;

    @Test
    void testGetClientById() {

        Client client = new Client();
        client.setClientId("client-001");
        client.setClientName("ABC Company");
        client.setEmail("abc@gmail.com");

        when(repository.findByClientId("client-001"))
                .thenReturn(Optional.of(client));

        ClientResponseDto response =
                service.getClientById("client-001");

        assertEquals(
                "client-001",
                response.getClientId());
    }

    @Test
    void testCreateClient_ClientAlreadyExists() {

        ClientRequestDto dto = new ClientRequestDto();
        dto.setEmail("abc@gmail.com");

        when(repository.existsByEmail("abc@gmail.com"))
                .thenReturn(true);

        assertThrows(
                ClientAlreadyExistsException.class,
                () -> service.createClient(dto));
    }

    @Test
    void testGetTotalClients() {

        when(repository.count()).thenReturn(15L);

        long total = service.getTotalClients();

        assertEquals(15L, total);
    }
}