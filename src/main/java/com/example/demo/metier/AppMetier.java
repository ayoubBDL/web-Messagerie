package com.example.demo.metier;

import java.util.ArrayList;

import com.example.demo.Beans.*;

import antlr.collections.List;
public interface AppMetier {

	public User displayU(String MLE);
	public Message displayM(Long id );
	public void AjoutM(Message m);
	public ArrayList<Message> displayAllM();
	public boolean findUser(String MLE, String password);
	public void deleteM(Long id);
	
}
