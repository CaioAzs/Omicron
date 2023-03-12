package com.caioazs.semina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.caioazs.semina.models.Client;
import com.caioazs.semina.repositories.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(Client client) throws Exception {
        return clientRepository.save(client);
    }
}
