package com.clearsettle.domain;

import java.util.Date;

/**
 * 
 * @author taner çakýroðlu
 * @comment simple pojo
 */

public class Report {

	private Date fromDate;
	private Date toDate;
	private int merchant;
	private int acquirer;
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getMerchant() {
		return merchant;
	}
	public void setMerchant(int merchant) {
		this.merchant = merchant;
	}
	public int getAcquirer() {
		return acquirer;
	}
	public void setAcquirer(int acquirer) {
		this.acquirer = acquirer;
	}
	
	
}
