package com.twt.demo.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table 
public class Message {
	@Id  
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  
	
	@Column  
	private String content;  
	
	@Column  
	private String email;
	
	public Message() {}
	
	public Message(int id, String content, String email) {
		this.id= id;
		this.content = content;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	} 
}
