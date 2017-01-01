package com.clearsettle.response.domain;

/**
 * 
 * @author taner cakiroglu
 * @comment simple pojo
 */

public class ReportResponse extends BaseResponse {

	 private int count ;
	 private int total ;
	 private String currency;
	
	 
	 public ReportResponse(){};
	 
	 public ReportResponse(String status, int count, int total, String currency) {
		super(status);
		this.count = count;
		this.total = total;
		this.currency = currency;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	 
	 
	 
}
