package com.example.demo.Beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_MESSAGE",discriminatorType=DiscriminatorType.STRING)
public abstract class Message implements Serializable {
	
		@Id 
		@GeneratedValue
		private Long id;
		private Date  date;
		private String objet;
		private String message ;
		
		
		@ManyToOne
		@JoinColumn(name="CODE_USER")
		private User user;
		
		@ManyToOne
		@JoinColumn(name="CODE_USERS")
		private User userS;
		public Message() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Message(Date date, String objet, String message, User user, User userS) {
			super();
			this.date = date;
			this.objet = objet;
			this.message = message;
			this.user = user;
			this.userS = userS;
		}


		public Long	 getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public User getUserS() {
			return userS;
		}


		public void setUserS(User userS) {
			this.userS = userS;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
		}


		public String getObjet() {
			return objet;
		}


		public void setObjet(String objet) {
			this.objet = objet;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}
		
}
