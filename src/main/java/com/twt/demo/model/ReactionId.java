package com.twt.demo.model;

import java.io.Serializable;

public class ReactionId implements Serializable{
	private int msgId;

    private String email;
    
    public ReactionId() {
    	
    }
    
    public ReactionId(int msgId, String email) {
        this.msgId = msgId;
        this.email = email;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (o == this)
            return true;
        if (!(o instanceof ReactionId))
            return false;
        
        ReactionId other = (ReactionId)o;
        boolean emailEquals = (this.email == null && other.email == null)
          || (this.email != null && this.email.equals(other.email));
        
        return this.msgId == other.msgId && emailEquals;
    }
    
    @Override
    public final int hashCode() {
    	int result = 17;
        if (email != null) {
            result = 31 * result + email.hashCode();
        }
        if (msgId != 0) {
            result = 31 * result + msgId;
        }
        return result;
    }
}
