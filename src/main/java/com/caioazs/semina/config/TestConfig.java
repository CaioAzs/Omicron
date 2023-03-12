package com.caioazs.semina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caioazs.semina.models.Client;
import com.caioazs.semina.repositories.ClientRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	ClientRepository clientRep;

	@Override 
	public void run(String... args) throws Exception {
			Client c1  = new Client();
			clientRep.save(c1);
	}
}
