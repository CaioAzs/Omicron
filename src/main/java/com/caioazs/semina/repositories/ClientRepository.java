package com.caioazs.semina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioazs.semina.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
