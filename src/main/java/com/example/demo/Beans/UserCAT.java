package com.example.demo.Beans;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Description;

@Entity
@DiscriminatorValue("CAT")
public class UserCAT extends User{

	public UserCAT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCAT(String mLE, String nom, String prenom, String societe,String password) {
		super(mLE, nom, prenom, societe,password);
		// TODO Auto-generated constructor stub
	}

	
}
