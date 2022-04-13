package com.twt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;

import com.twt.demo.model.Emo;
import com.twt.demo.model.Message;
import com.twt.demo.model.Reaction;
import com.twt.demo.service.TwService;
import com.twt.demo.service.ValidationService;  

@RestController 
public class TwController {

	@Autowired  
	TwService twService; 
	
	@Autowired  
	ValidationService valService; 
	
	@PostMapping("/message")
	private int saveMessage(@RequestBody Message message)   
	{  
		if(valService.validate(message)) {
			twService.saveMessage(message);  
			return message.getId(); 
		}
		return -1;
		 
	}
	
	@PostMapping("/reaction")
	private int saveReaction(@RequestBody Reaction reaction)   
	{  
		if(valService.validate(reaction)) {
			twService.saveReaction(reaction);
			return reaction.getMsgId(); 
		}
		return -1;
		 
	}  
	
	@GetMapping("/reaction/{message_id}")
	private List<Reaction> getReaction(@PathVariable("message_id") int id)   
	{  
		return twService.getReactionByMessageId(id);
		 
	}  
	
	@GetMapping("/emo")  
	private List<Emo> getAllStudent()   
	{  
		return twService.getAllEmo();  
	}  
}
