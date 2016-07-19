package com.lancefallon.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.lancefallon.model.User;
import com.lancefallon.service.SigninService;

@Component
public class RestAuthProvider implements AuthenticationProvider {
	
	@Autowired
	private SigninService signinService;
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try{
        	User user = this.signinService.signin(username, password);
        	user.setPassword("");
        	List<GrantedAuthority> grantedAuths = new ArrayList<>();
        	
        	//TODO get roles from database
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            
            Authentication auth = new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
            return auth;
        } catch(Exception e){
        	return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
