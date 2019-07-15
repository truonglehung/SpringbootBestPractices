package com.vsolu.restfuljpa.payload;

public class SystemResponse {
	
	private String errorcode;
	private String message;
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public SystemResponse(String errorcode, String message) {
		super();
		this.errorcode = errorcode;
		this.message = message;
	}
	public SystemResponse() {
		super();
	}
	
	
}
