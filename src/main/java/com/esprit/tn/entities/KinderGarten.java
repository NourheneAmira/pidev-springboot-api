package com.esprit.tn.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;

//import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity 
@Table(name="KINDERGARTEN")
public class KinderGarten {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KinderGarten_id")
	private Long idKindergarten;
	
	private String adresse;
	private String Email;
	private int capacite ;
	private int tel;
	private Float prix;
	@JsonIgnore
	@Transient 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kinderGarten",fetch=FetchType.LAZY)
	private Collection<Event> events = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy="kinderGartenn",fetch=FetchType.LAZY)
	private Collection<Parent> parentts = new ArrayList<>();
	public Long getIdKindergarten() {
		return idKindergarten;
	}
	public void setIdKindergarten(Long idKindergarten) {
		this.idKindergarten = idKindergarten;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public Collection<Event> getEvents() {
		return events;
	}
	public void setEvents(Collection<Event> events) {
		this.events = events;
	}
	
	

}
