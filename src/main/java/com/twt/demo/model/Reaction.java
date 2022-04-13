package com.twt.demo.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;  

@Entity  
@Table 
@IdClass(ReactionId.class)
public class Reaction {
	
	@Id
	@Column
	private int msgId;  
	
	@Column  
	private String emo;  
	
	@Id
	@Column  
	private String email;

	public Reaction() {}

	public Reaction(int msgId, String emo, String email) {
		this.msgId = msgId;
		this.emo = emo;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getEmo() {
		return emo;
	}

	public void setEmo(String emo) {
		this.emo = emo;
	} 
}
