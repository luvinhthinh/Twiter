package com.twt.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.twt.demo.model.Message;
import com.twt.demo.model.Reaction;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ReactionRepositoryTest {
	
	@Autowired
    private ReactionRepository reactionRepository;
    private Reaction reaction;

    @BeforeEach
    public void setUp() {

    	reaction = new Reaction(1, "\\uD83D\\uDE04", "test@test.com");
    }

    @AfterEach
    public void tearDown() {
    	reactionRepository.deleteAll();
    	reaction = null;
    }
    
    @Test
    public void givenReactionToAddShouldReturnAddedReaction(){
    	reactionRepository.save(reaction);
    	List<Reaction> reactions = new ArrayList<Reaction>();  
		reactionRepository.findAll().forEach(reaction -> {
			if(reaction.getMsgId() == reaction.getMsgId()) {
				reactions.add(reaction);
			}
		});
        //assertEquals(product1.getName(),product2.getName());
        assertEquals(1, reactions.get(0).getMsgId());
    }
}
