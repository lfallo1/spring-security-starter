package com.lancefallon.webservices;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lancefallon.model.Config;
import com.lancefallon.model.User;

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
	
	/**
	 * example of a 
	 * @param id
	 * @param principal
	 * @return
	 */
	@RequestMapping(value="/filterable/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostFilter("@authService.canView(filterObject, #principal)")
	public List<User> filterableGet(@PathVariable("id") Integer id, Principal principal) {
		List<User> users = new ArrayList<>();
		users.add(new User("lfallo1", "","fallon.lance@gmail.com"));
		users.add(new User("admin123", "","admin@gmail.com"));
		users.add(new User("dev123", "","dev@gmail.com"));
		return users;
	}
}
