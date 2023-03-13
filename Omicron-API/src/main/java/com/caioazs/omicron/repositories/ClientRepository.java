package com.caioazs.omicron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioazs.omicron.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
