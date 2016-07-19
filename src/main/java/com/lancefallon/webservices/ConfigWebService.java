package com.lancefallon.webservices;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lancefallon.model.Config;

/**
 * configuration service
 * @author lfallon
 *
 */
@RestController
@RequestMapping("/api/config")
public class ConfigWebService {

	private Config config;
	
	@Autowired
	public void setConfig(Config config){
		this.config = config;
	}
	
	/**
	 * return environment configurations
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Config> configGET() {
		return new ResponseEntity<Config>(this.config, HttpStatus.OK);
	}

	@RequestMapping(value="/test/{id}", method = RequestMethod.GET)
	@PreAuthorize("@authService.grantAccess(#principal, #id)")
	public ResponseEntity<String> testGET(@PathVariable("id") Integer id, Principal principal) {
		return new ResponseEntity<String>("Okay", HttpStatus.OK);
	}
}
