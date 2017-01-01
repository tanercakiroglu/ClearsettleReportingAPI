package com.clearsettle.response.domain;

/**
 * 
 * @author taner çakýroðlu
 * @comment simple pojo
 */

import com.clearsettle.domain.Merchant;

public class MerchantResponse extends BaseResponse {

	private Merchant merchant;

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	
}
