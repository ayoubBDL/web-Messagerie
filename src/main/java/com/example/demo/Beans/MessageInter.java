package com.example.demo.Beans;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Intermediaire")
public class MessageInter extends Message{

	public MessageInter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageInter(Date date, String objet, String message, User user, User userS) {
		super(date, objet, message, user, userS);
		// TODO Auto-generated constructor stub
	}

	

	
}
