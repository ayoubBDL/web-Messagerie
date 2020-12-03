package com.example.demo.metier;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Beans.Message;
import com.example.demo.Beans.User;
import com.example.demo.dao.MessageRepository;
import com.example.demo.dao.UserRepository;

@Service
@Transactional
public class AppMetierImpl implements AppMetier{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	@Override
	public User displayU(String MLE) {
		// TODO Auto-generated method stub
		User u = userRepository.findById(MLE).get();
		if(u == null ) throw new RuntimeException("Utilisateur introuvable");
		return u;
	}

	@Override
	public Message displayM(Long id) {
		// TODO Auto-generated method stub
		Message m = messageRepository.findById(id).get();
		if(m == null) throw new RuntimeException("Message introuvable");
		return m;
	}

	@Override
	public void AjoutM(Message m) {
		// TODO Auto-generated method stub
		messageRepository.save(m);
	}
	
	@Override
	public ArrayList<Message> displayAllM() {
		ArrayList<Message> L=(ArrayList<Message>) messageRepository.findAll();
		
		return L;
	}

	@Override
	public boolean findUser(String MLE ,String password) {
		User u = userRepository.findById(MLE).get();
		if(u==null || !u.getPassword().equals(password)) return false;
		return true;
	}

	@Override
	public void deleteM(Long id) {
		messageRepository.deleteById(id);
		
	}

	
}
