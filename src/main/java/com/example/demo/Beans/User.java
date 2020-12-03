package com.example.demo.Beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER",discriminatorType=DiscriminatorType.STRING)
public abstract class User implements Serializable{

	@Id
	private String MLE;
	private String nom;
	private String prenom;
	private String societe;
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Collection<Message> Messages;
	
	@OneToMany(mappedBy = "userS", fetch = FetchType.LAZY)
	private Collection<Message> Message;
	
	
	
	public String getMLE() {
		return MLE;
	}

	public void setMLE(String mLE) {
		MLE = mLE;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public Collection<Message> getMessages() {
		return Messages;
	}

	public void setMessages(Collection<Message> messages) {
		Messages = messages;
	}

	public User(String mLE, String nom, String prenom, String societe, String password) {
		super();
		MLE = mLE;
		this.nom = nom;
		this.prenom = prenom;
		this.societe = societe;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
