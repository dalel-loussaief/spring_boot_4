package com.dalel.vetements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dalel.vetements.entities.Genre;
import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.repos.VetementRepository;
@Service
public class VetementServiceImpl  implements VetementService {
	@Autowired
	VetementRepository vetementRepository;

	@Override
	public Vetement saveVetement(Vetement v) {
		
		return vetementRepository.save(v);
	}

	@Override
	public Vetement updateVetement(Vetement v) {
		
		return vetementRepository.save(v);
	}

	@Override
	public void deleteVetement(Vetement v) {
		vetementRepository.delete(v);
		
	}

	@Override
	public void deleteVetementById(Long id) {
		vetementRepository.deleteById(id);
		
	}

	@Override
	public Vetement getVetement(Long id) {
		
		return vetementRepository.findById(id).get();
	}

	@Override
	public List<Vetement> getAllVetement() {
		
		return vetementRepository.findAll();
	}

	@Override
	public Page<Vetement> getAllVetementParPage(int page, int size) {
		
		return vetementRepository.findAll(PageRequest.of(page, size));
	}

	

	@Override
	public List<Vetement> findByNomVetement(String nom) {
		
		return vetementRepository.findByNomvetement(nom);
	}

	@Override
	public List<Vetement> findByNomVetementContains(String nom) {
		return vetementRepository.findByNomvetementContains(nom);
	}

	@Override
	public List<Vetement> findByNomPrix(String nom, Double prix) {
		return vetementRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Vetement> findByGenre(Genre genre) {
		return vetementRepository.findByGenre(genre);
	}

	@Override
	public List<Vetement> findByGenreIdG(Long id) {
		return vetementRepository.findByGenreIdG(id);
	}

	@Override
	public List<Vetement> findByOrderByNomvetementAsc() {
		return vetementRepository.findByOrderByNomvetementAsc();
	}

	@Override
	public List<Vetement> trierVetementsNomsPrix() {
		return vetementRepository.trierVetementNomsPrix();
	}
	
	
	
}
