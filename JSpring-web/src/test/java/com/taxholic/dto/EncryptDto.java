package com.taxholic.dto;

import com.taxholic.core.annotation.Encrypt;

public class EncryptDto {
	
	private String user;	
	@Encrypt
	private String passwd;
	private String url;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
}
