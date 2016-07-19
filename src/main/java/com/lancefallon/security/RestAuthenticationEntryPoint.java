package com.lancefallon.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;

public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;

		httpResponse.setContentType("application/json");
		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		httpResponse.getOutputStream().println("{ \"error\": \"Y'aint got access foo!\" }");		
	}
}
