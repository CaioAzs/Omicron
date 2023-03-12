package com.caioazs.semina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caioazs.semina.models.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
    
}
