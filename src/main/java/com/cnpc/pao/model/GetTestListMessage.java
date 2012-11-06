package com.cnpc.pao.model;

import java.io.Serializable;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class GetTestListMessage implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String message;

	public GetTestListMessage() {

	}

	public GetTestListMessage(String message){
		this.message = message;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
