package com.twt.demo.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.twt.demo.model.Message;
import com.twt.demo.model.Reaction;
import com.twt.demo.repository.MessageRepository;
import com.twt.demo.repository.ReactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TwServiceTest {

	@Mock
    private MessageRepository messageRepository;
	
	@Mock  
	ReactionRepository reactionRepository; 
	
	@Autowired
    @InjectMocks
    private ValidationService validationService;
	
	@Autowired
    @InjectMocks
    private TwService twService;
	
	private Message message;
	private Reaction reaction;
	
	@BeforeEach
    public void setUp() {
		message = new Message(1, "test message", "test@test.com");
		reaction = new Reaction(1, "\\uD83D\\uDE04", "test@test.com");
    }

    @AfterEach
    public void tearDown() {
        message = null;
        messageRepository.deleteAll();
    }
    
    @Test
    void givenMessageToAddShouldReturnAddedMessage() {
        when(messageRepository.save(any())).thenReturn(message);
        twService.saveMessage(message);
        verify(messageRepository,times(1)).save(any());
    }
    
    @Test
    void givenReactionToAddShouldReturnAddedReaction() {
        when(reactionRepository.save(any())).thenReturn(reaction);
        twService.saveReaction(reaction);
        verify(reactionRepository,times(1)).save(any());
    }
    
    

}
