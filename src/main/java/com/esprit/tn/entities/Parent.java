package com.esprit.tn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity 
@Table(name="Parent")
public class Parent implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String image;
	private String Email;
	private String adresse;
	private int tel;
	private Date dateNaissance;
	@JsonIgnore
	@Transient 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="parents",fetch=FetchType.LAZY)
	private Collection<Notification> notifications= new ArrayList<>();
	
//	@ManyToMany(cascade = CascadeType.ALL, mappedBy="parent1s",fetch=FetchType.LAZY)
	//private Collection<Event> participations= new ArrayList<>();
	
	@ManyToOne
	private KinderGarten kinderGartenn;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(Long id, String firstName, String lastName, String image, String email, String adresse, int tel,
			Date dateNaissance, Collection<Notification> notifications, Collection<Event> participations) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		Email = email;
		this.adresse = adresse;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.notifications = notifications;
		
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", image=" + image
				+ ", Email=" + Email + ", adresse=" + adresse + ", tel=" + tel + ", dateNaissance=" + dateNaissance
				+ ", notifications=" + notifications + "]";
	}
	public Collection<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Collection<Notification> notifications) {
		this.notifications = notifications;
	}
	
}
