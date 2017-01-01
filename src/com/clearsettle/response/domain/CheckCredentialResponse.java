package com.clearsettle.response.domain;

/**
 * 
 * @author taner cakiroglu
 * @comment simple pojo
 */

public class CheckCredentialResponse extends BaseResponse {

	private String token;

	public CheckCredentialResponse(String status, String token) {
		super(status);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
