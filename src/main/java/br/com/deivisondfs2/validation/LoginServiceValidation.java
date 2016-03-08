package br.com.deivisondfs2.validation;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceValidation {
	
	public boolean isValidUser(String name, String password) {
		if (name != "" && password != "") {
			return true;
		}
		return false;
	}
	
}
