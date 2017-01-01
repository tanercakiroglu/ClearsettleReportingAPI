package com.clearsettle.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author taner çakýroðlu
 * @comment simple pojo
 */

public class Role implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
