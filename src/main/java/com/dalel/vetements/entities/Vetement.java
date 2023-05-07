package com.dalel.vetements.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Vetement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idvetement;
	@NotNull
	@Size (min = 4,max = 15)
	private String nomvetement;
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixvetement;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateprod;
	
	@ManyToOne
	private Genre genre;
	
	
	public Vetement(String nomvetement, Double prixvetement, Date dateprod) {
		super();
		this.nomvetement = nomvetement;
		this.prixvetement = prixvetement;
		this.dateprod = dateprod;
	}
	public Vetement() {
		super();
	
	}
	public Long getIdvetement() {
		return idvetement;
	}
	public void setIdvetement(Long idvetement) {
		this.idvetement = idvetement;
	}
	public String getNomvetement() {
		return nomvetement;
	}
	public void setNomvetement(String nomvetement) {
		this.nomvetement = nomvetement;
	}
	public Double getPrixvetement() {
		return prixvetement;
	}
	public void setPrixvetement(Double prixvetement) {
		this.prixvetement = prixvetement;
	}
	public Date getDateprod() {
		return dateprod;
	}
	public void setDateprod(Date dateprod) {
		this.dateprod = dateprod;
	}
	@Override
	public String toString() {
		return "Vetement [idvetement=" + idvetement + ", nomvetement=" + nomvetement + ", prixvetement=" + prixvetement
				+ ", dateprod=" + dateprod + "]";
	}
	
	

}
