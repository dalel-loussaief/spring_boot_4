package com.dalel.vetements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@SpringBootApplication
public class Vetements2Application implements CommandLineRunner {

	@Autowired
	VetementService vetementService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Vetements2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Vetement.class);
		
	//vetementService.saveVetement(new Vetement("robe",100.900,new Date()));
	//vetementService.saveVetement(new Vetement("robe", 280.200, new Date()));
	//vetementService.saveVetement(new Vetement("pull", 50.300, new Date()));
}}
