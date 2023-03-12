package com.caioazs.omicron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioazs.omicron.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
    
}
