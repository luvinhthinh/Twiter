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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ValidationServiceTest {

	@Mock
    private MessageRepository messageRepository;
	
	@Autowired
    @InjectMocks
    private ValidationService validationService;
	private Message message;
	
	@BeforeEach
    public void setUp() {
		message = new Message(1, "test message", "test@test.com");
		
    }

    @AfterEach
    public void tearDown() {
        message = null;
        messageRepository.deleteAll();
    }
    
    @Test
    void givenEmptyMessageShouldReturnFalse(){
    	assertEquals(false, validationService.validate(new Message(1, "", "abc@abc.com")));
    }
    
    @Test
    void givenLongMessageShouldReturnFalse(){
    	String text161 = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891";
    	assertEquals(false, validationService.validate(new Message(1, text161, "abc@abc.com")));

    }
    
    @Test
    void givenValidMessageShouldReturnTrue(){
    	String text160 = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789";
    	assertEquals(true, validationService.validate(new Message(1, text160, "abc@abc.com")));

    }

    @Test
    void givenInvalidEmailShouldReturnFalse(){
    	assertEquals(false, validationService.validate(new Message(1, "test", "abcabc.com")));
    }
    
    @Test
    void givenInvalidMessageIdShouldReturnFalse(){
    	Mockito.when(messageRepository.findById(1000)).thenReturn(Optional.empty());
    	assertEquals(false, validationService.validate(new Reaction(1000, "\\uD83D\\uDE04", "abc@abc.com")));
    }
    
    @Test
    void givenInvalidEmailInReactionShouldReturnFalse(){
    	Mockito.when(messageRepository.findById(1)).thenReturn(Optional.of(message));
    	assertEquals(false, validationService.validate(new Reaction(1, "\\uD83D\\uDE04", "abcabc.com")));
    }
    
    @Test
    void givenValidReactionShouldReturnTrue(){
    	Mockito.when(messageRepository.findById(1)).thenReturn(Optional.of(message));
    	assertEquals(true, validationService.validate(new Reaction(1, "\\uD83D\\uDE04", "abc@abc.com")));
    }
}
