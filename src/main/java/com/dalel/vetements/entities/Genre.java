package com.dalel.vetements.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idG;
	private String nom;
	private String description;
	private String taille;
	
	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	private List<Vetement> vetements;
	
	
	
	public Genre(Long id, String nom, String description, String taille) {
		super();
		this.idG = id;
		this.nom = nom;
		this.description = description;
		this.taille = taille;
	}
	public Genre() {
		super();
		
	}
	public Long getIdG() {
		return idG;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public List<Vetement> getVetements() {
		return vetements;
	}
	public void setVetements(List<Vetement> vetements) {
		this.vetements = vetements;
	}
	@Override
	public String toString() {
		return "Genre [idG=" + idG + ", nom=" + nom + ", description=" + description + ", taille=" + taille
				+ ", vetements=" + vetements + "]";
	}




}
