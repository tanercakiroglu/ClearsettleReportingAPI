package com.clearsettle.response.domain;

/**
 * 
 * @author taner çakýroðlu
 * @comment simple pojo
 */

public class ErrorResponse extends BaseResponse {
	
	private Object errorMessage;
	
	
	public ErrorResponse(String status,Object errorMessage) {
		super(status);
		this.errorMessage=errorMessage;
	}
	public Object getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(Object errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
