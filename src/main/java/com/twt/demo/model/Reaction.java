package com.twt.demo.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table 
public class Reaction {
	
	@Id
	@Column
	private int msgId;  
	
	@Column  
	private String emo;  
	
	@Column  
	private String email;

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
