package com.dalel.vetements.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class VetementRESTController {
	@Autowired
	VetementService vetementService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Vetement> getAllVetement() {
	return vetementService.getAllVetement();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Vetement getVetementById(@PathVariable("id") Long id) {
	return vetementService.getVetement(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public Vetement createVetement(@RequestBody Vetement vetement) {
		return vetementService.saveVetement(vetement);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Vetement updateVetement(@RequestBody Vetement vetement) {
	return vetementService.updateVetement(vetement);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVetement(@PathVariable("id") Long id)
	{
		vetementService.deleteVetementById(id);
	}
	@RequestMapping(value="/vetGen/{idG}",method = RequestMethod.GET)
	public List<Vetement> getVetementByCatId(@PathVariable("idG") Long idG) {
	return vetementService.findByGenreIdG(idG);
	}
}
