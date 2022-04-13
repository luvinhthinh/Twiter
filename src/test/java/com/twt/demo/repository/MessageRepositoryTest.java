package com.twt.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.twt.demo.model.Message;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MessageRepositoryTest {
	
	@Autowired
    private MessageRepository messageRepository;
    private Message message;

    @BeforeEach
    public void setUp() {

    	message = new Message(1,"test message", "test@test.com");
    }

    @AfterEach
    public void tearDown() {
    	messageRepository.deleteAll();
    	message = null;
    }
    
    @Test
    public void givenMessageToAddShouldReturnAddedMessage(){
    	messageRepository.save(message);
    	Message fetchedMessage = messageRepository.findById(message.getId()).get();
        assertEquals(1, fetchedMessage.getId());
    }
}
