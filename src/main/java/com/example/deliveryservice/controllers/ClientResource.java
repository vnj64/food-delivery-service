package com.example.deliveryservice.controllers;

import com.example.deliveryservice.models.Orders;
import com.example.deliveryservice.repository.ClientRepository;
import com.example.deliveryservice.service.ClientService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.Cleaner;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class ClientResource {
    private final Logger log = LoggerFactory.getLogger(ClientResource.class);

    private static final String ENTITY_NAME="client";

    @Value("${spring.application.name}")
    private String applicationName;

    private final ClientRepository clientRepository;

    private final ClientService clientService;

    public ClientResource(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @PostMapping("/orders")
    @Transactional
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) throws URISyntaxException {
        log.debug("REST request to save order: {}", order);

    }
}
