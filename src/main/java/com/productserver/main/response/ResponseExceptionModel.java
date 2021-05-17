package com.productserver.main.response;


public class ResponseExceptionModel {
	private int status_code;
	private String message;
	
	public ResponseExceptionModel(int status_code) {
		this.status_code = status_code;
	}

	
	public int getStatus() {
		return status_code;
	}
	public void setStatus(int status) {
		this.status_code = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
