package com.example.demo.web;

import java.sql.Date;
//import java.util.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Beans.Message;
import com.example.demo.Beans.MessageCAT;
import com.example.demo.Beans.User;
import com.example.demo.Beans.UserCAT;
import com.example.demo.ChatApp.model.ChatMessage;
import com.example.demo.metier.AppMetier;

@Controller
public class AppController {
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@Autowired
	private AppMetier appMetier;
	
	@RequestMapping("/Login")
	public String index() {
		return "Login";
	}

	
	@RequestMapping("/Interface")
	public String principale() {
		return "Fragments/Header";
	}
	
	
	@RequestMapping("/messages")
	public String page() {
		return "Login";
	}
	@RequestMapping("/file")
	public String file() {
		return "file";
	}
	
	@RequestMapping("/Inscription")
	public String inscription() {
		return "Inscription";
	}
	
	
	  @RequestMapping("/consulterMessage") 
	  public String consulter(Model model,String ref,Long codeMessage, 
	  @RequestParam(name="page", defaultValue="0") int page,
	  @RequestParam(name="size", defaultValue="5") int size){
	  model.addAttribute("codeMessage", codeMessage); 
	  try{
	  
	  //Message m = appMetier.displayM(codeMessage); model.addAttribute("mes", m);
	  ArrayList<Message> L=appMetier.displayAllM();model.addAttribute("list",L);
	  }
	  catch (Exception e) { model.addAttribute("exception",e); } 
	  model.addAttribute("ref", ref);
	  return "messages";
	  }
	 
	
	@RequestMapping("/New")
	public String New(Model model , String ref ,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size)
	{	model.addAttribute("ref",ref);
		return "NouveauMessage";
	}
	
	@RequestMapping("/MessagesReçus")
	public String reçu() {
		
		return "MessagesReçus";
	}
	@RequestMapping("/MessagesEnvoyés")
	public String envoieString(Model model,Long codeMessage, 
			  @RequestParam(name="page", defaultValue="0") int page,
			  @RequestParam(name="size", defaultValue="5") int size){
			  model.addAttribute("codeMessage", codeMessage); 
			  try{
			  
			  //Message m = appMetier.displayM(codeMessage); model.addAttribute("mes", m);
			  ArrayList<Message> L=appMetier.displayAllM();model.addAttribute("list",L);
			  }
			  catch (Exception e) { model.addAttribute("exception",e); }
		return "MessagesEnvoyés";
	}
	@RequestMapping("/test")
	public String Test(Model model , String MLE ,String password,@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size)
	{
	
			try {
				if (appMetier.findUser(MLE,password)) {
					model.addAttribute("ref",MLE);
					return "Fragments/Header";
				}
			} catch (Exception e) {
				model.addAttribute("error",e);
				return "redirect:/Login?error="+e.getMessage();
			}
			
			return "redirect:/Login";
			
		
	}
	
	@RequestMapping("/NouveauMessage")
	public  String Ajouter(Model model,String ref, String MLE, String objetMessage,String message,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		//model.addAttribute("codeMessage", codeMessage);
		try{
			
			User u=appMetier.displayU(MLE);
			
			User u1=appMetier.displayU(ref);
			
			Date dateMe=new Date(System.currentTimeMillis());
			
			appMetier.AjoutM(new MessageCAT(dateMe,objetMessage,message,u,u1));
		
			
			
		} catch (Exception e) {
			
			model.addAttribute("exception",e);
		}
		return "messages";
	}
	
	@RequestMapping("/delete")
	public String Supprimer(Model model,Long id,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="5") int size){
		//model.addAttribute("codeMessage", codeMessage);
		try{
			
			appMetier.deleteM(id);
			
			
		} catch (Exception e) {
			
			model.addAttribute("exception",e);
		}
		return "messages";
	}
}
