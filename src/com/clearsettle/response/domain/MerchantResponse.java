package com.clearsettle.response.domain;

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
