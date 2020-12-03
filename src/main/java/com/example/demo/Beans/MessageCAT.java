package com.example.demo.Beans;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAT")

public class MessageCAT extends Message{

	public MessageCAT() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public MessageCAT(Date date, String objet, String message, User user, User
	 * userS) { super(date, objet, message, user, userS); // TODO Auto-generated
	 * constructor stub }
	 */

	public MessageCAT(Date dateMe, String objetMessage, String message, User u, User u1) {
		// TODO Auto-generated constructor stub
		super(dateMe, objetMessage, message, u,u1);
	}

	
}
