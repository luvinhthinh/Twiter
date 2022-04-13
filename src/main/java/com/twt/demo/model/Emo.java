package com.twt.demo.model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity  
@Table 
public class Emo {
	
	@Id
	@Column  
	private String code;  
	
	@Column  
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
