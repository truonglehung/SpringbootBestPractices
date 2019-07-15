package com.vsolu.restfuljpa.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ResponseChatbot implements Serializable   {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@SerializedName("set_attributes") 
	 @JsonProperty("set_attributes")
    private HashMap<String, String> attributes;
    
//    @SerializedName("messages")
     @JsonProperty("messages")
	 private List<?> messagechatbot;
    
	public HashMap<String, String> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	 
	public List<?> getMessagechatbot() {
		return messagechatbot;
	}

	public void setMessagechatbot(List<?> messagechatbot) {
		this.messagechatbot = messagechatbot;
	}
	public ResponseChatbot() {
		super();
	}
    
}
