package com.lancefallon.security;

import java.security.Principal;

import org.springframework.stereotype.Component;

@Component("authService")
public class RestAuthService {
	public Boolean grantAccess(Principal principal, Integer id){
		if(principal != null){
			String name = principal.getName();
			System.out.println(name);	
		}
		return principal != null;
	}
}
