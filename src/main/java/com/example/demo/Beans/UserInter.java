package com.example.demo.Beans;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Intermediaire")
public class UserInter extends User{

	public UserInter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInter(String mLE, String nom, String prenom, String societe,String password) {
		super(mLE, nom, prenom, societe,password);
		// TODO Auto-generated constructor stub
	}

	
}
