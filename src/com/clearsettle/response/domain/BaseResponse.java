package com.clearsettle.response.domain;

/**
 * 
 * @author taner cakiroglu
 * @comment base response 
 */

public abstract class BaseResponse {

	private String status;
	
	
	public BaseResponse(){};

	public BaseResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
