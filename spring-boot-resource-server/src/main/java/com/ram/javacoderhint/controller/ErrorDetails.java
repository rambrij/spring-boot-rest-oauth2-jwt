package com.ram.javacoderhint.controller;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

	private HttpStatus status;
	private String timestamp;

	private String message;
	private String details;

	public ErrorDetails(String timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	

	public ErrorDetails(HttpStatus status, String timestamp, String message, String details) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}



	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
	}

}