package com.caioazs.omicron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caioazs.omicron.models.Client;
import com.caioazs.omicron.repositories.ClientRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	ClientRepository clientRep;

	@Override 
	public void run(String... args) throws Exception {
			Client c1  = new Client();
			c1.setCpf("52795669854");
			c1.setName("Caio");
			c1.setEmail("souzascai23cs@gmail.com");
			c1.setPhone("40028922");
			clientRep.save(c1);
	}
}
