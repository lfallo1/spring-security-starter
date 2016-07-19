package com.lancefallon.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * autowire properties
 * @author lancefallon
 *
 */
@Component
@PropertySources({
    @PropertySource("classpath:settings/springsecurity.properties"),
    @PropertySource("classpath:shared.properties")
})
public class Config {
	
	@Value("${categories}")
	private String[] categories;
	
	public Config(){
	}
	
	public String[] getCategories() {
		return categories;
	}
	
}
