package com.caioazs.omicron.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.caioazs.omicron.models.Client;
import com.caioazs.omicron.repositories.ClientRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody @Valid Client client) throws Exception {
        return clientRepository.save(client);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws Exception {
        findById(id);
        clientRepository.deleteById(id); // throws NotFoundException if Client doesnt exist because of the findById method
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody @Valid Client client_request) throws Exception{
        clientRepository
                .findById(id)
                .map(client ->{

                    if (client_request.getName() != null)
                    client.setName(client_request.getName());
                    if (client_request.getEmail()!= null)
                    client.setEmail(client_request.getEmail());
                    if (client_request.getPhone() != null)
                    client.setPhone(client_request.getPhone());
                    if (client_request.getCpf() != null)
                    client.setCpf(client_request.getCpf());
                    return clientRepository.save(client); 
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
