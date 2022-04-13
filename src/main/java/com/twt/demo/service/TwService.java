package com.twt.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.twt.demo.repository.EmoRepository;
import com.twt.demo.repository.MessageRepository;
import com.twt.demo.repository.ReactionRepository;
import com.twt.demo.model.Emo;
import com.twt.demo.model.Message;
import com.twt.demo.model.Reaction;

@Service  
public class TwService {

	@Autowired  
	MessageRepository messageRepository;  
	
	@Autowired  
	ReactionRepository reactionRepository; 
	
	@Autowired  
	EmoRepository emoRepository; 
	
	public int saveMessage(Message message){  
		Message msg = messageRepository.save(message);  
		return msg.getId();
	}  
	
	public int saveReaction(Reaction reaction) {
		Reaction react = reactionRepository.save(reaction);
		return react.getMsgId();
	}
	
	public List<Emo> getAllEmo(){  
		List<Emo> emos = new ArrayList<Emo>();  
		emoRepository.findAll().forEach(emo -> emos.add(emo));  
		return emos;  
	}   
	
	public List<Reaction> getReactionByMessageId(int id){
		List<Reaction> reactions = new ArrayList<Reaction>();  
		reactionRepository.findAll().forEach(reaction -> {
			if(reaction.getMsgId() == id) {
				reactions.add(reaction);
			}
		});
		return reactions;
	}
}
