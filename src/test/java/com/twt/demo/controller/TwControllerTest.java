package com.twt.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twt.demo.model.Message;
import com.twt.demo.model.Reaction;
import com.twt.demo.service.TwService;
import com.twt.demo.service.ValidationService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TwControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Mock
    private TwService twService;
	
	@Mock
	private ValidationService valService; 
	
	@InjectMocks
    private TwController twController;
	
	private Message message;
	private Reaction reaction;
	
	@BeforeEach
    public void setup(){
		message = new Message(1, "test message", "test@test.com");
		reaction = new Reaction(1, "\\uD83D\\uDE04", "test@test.com");
        mockMvc = MockMvcBuilders.standaloneSetup(twController).build();
    }

    @AfterEach
    void tearDown() {
    	message = null;
    	reaction = null;
    }
    
    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void PostMappingOfMessage() throws Exception{
//        when(twService.saveMessage(any())).thenReturn(3);
        
        mockMvc.perform(post("/message").
                contentType(MediaType.APPLICATION_JSON).
                content("{\n    \"content\" : \"abc\",\n    \"email\" : \"abc@abc.com\"\n}")).
                andExpect(status().isOk());
//        verify(twService, atLeast(1)).saveMessage(any());
    }
    
    @Test
    public void PostMappingOfReaction() throws Exception{
//        when(twService.saveMessage(any())).thenReturn(3);
        
        mockMvc.perform(post("/reaction").
                contentType(MediaType.APPLICATION_JSON).
                content("{\n    \"emo\" : \"\\uD83D\\uDE04\",\n    \"email\" : \"mono1@abc.com\",\n    \"msgId\": 2\n}")).
                andExpect(status().isOk());
//        verify(twService, atLeast(1)).saveMessage(any());
    }
}
