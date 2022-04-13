package com.twt.demo.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.twt.demo.repository.EmoRepository;
import com.twt.demo.repository.MessageRepository;  
import com.twt.demo.model.Message;
import com.twt.demo.model.Reaction;

@Service  
public class ValidationService {
	
	@Autowired  
	MessageRepository messageRepository;  
	
	@Autowired  
	EmoRepository emoRepository; 

	public boolean validate(Message message){  
		return message != null && 
				checkContent(message.getContent()) &&
						checkEmail(message.getEmail());
	}  
	
	public boolean validate(Reaction reaction){  
		return reaction != null &&
//				checkIfReactionExist(reaction.getEmo()) &&
				checkIfMessageExist(reaction.getMsgId()) &&
						checkEmail(reaction.getEmail());
	}
	
	private boolean checkIfMessageExist(int id) {
		return (!messageRepository.findById(id).isEmpty());
	}
	
	private boolean checkIfReactionExist(String reaction) {
		final boolean[] hasElements = {false};
		emoRepository.findAll().forEach(emo -> {
			if(emo.getCode().equalsIgnoreCase(reaction)) {
				hasElements[0] = true;
			}
		});
		return hasElements[0];
	}
	
	private boolean checkContent(String content) {
		return (content != null && 
				content.length() > 0 && content.length() <= 160);
	}
	
	private boolean checkEmail(String email) {
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
		        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		
		return Pattern.compile(regexPattern)
			      .matcher(email)
			      .matches();
	}
}
