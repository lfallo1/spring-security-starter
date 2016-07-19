package com.lancefallon.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import com.lancefallon.model.User;

@Component("authService")
public class RestAuthService {
	public Boolean grantAccess(UsernamePasswordAuthenticationToken token, Integer id){
		if(token == null){
			return false;
		}
		User activeUser = (User) token.getPrincipal();
		String name = activeUser.getUsername();
		System.out.println(name);
		return true;
	}
	
	
	public Boolean canView(User user, UsernamePasswordAuthenticationToken token){
		if(token == null){
			return false;
		}
		User activeUser = (User) token.getPrincipal();
		return user.getUsername().toLowerCase().equals(activeUser.getUsername());
	}
}
