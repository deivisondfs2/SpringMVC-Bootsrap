package br.com.deivisondfs2.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public boolean isValidUser(String name, String password) {
		if (name != "" && password != "") {
			return true;
		}
		return false;
	}
	
}
