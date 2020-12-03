package com.example.demo;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.MessageRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.Beans.*;
import com.example.demo.metier.AppMetier;

@SpringBootApplication
public class MyProjectApplication implements CommandLineRunner{

	
	  @Autowired private UserRepository userRepository;
	  
	  @Autowired private MessageRepository messageRepository;
	  
	  @Autowired private AppMetier appMetier;
	 
	
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		  User c1 = userRepository.save(new UserInter("ab34", "kaoussi", "abdelghani",
		  "cart","1234")) ;
		  
		  User c2 = userRepository.save(new UserCAT("ar90", "zekri", "Adil",
		  "Citron","1234")) ;
		  
		  Message m1=messageRepository.save(new MessageInter(new Date(0), "Test",
		  "Bonjour", c1,c2)); Message m2=messageRepository.save(new MessageCAT(new
		  Date(0), "deal", "Bonsoir", c2,c1));
		 
	}

	

}
