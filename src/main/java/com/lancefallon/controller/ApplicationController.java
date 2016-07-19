package com.lancefallon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
	
	/**
	 * return index.jsp
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndex(){
		return "index";
	}
	
	/**
	 * redirect page not found to index
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping(value="/Error", method=RequestMethod.GET)
    public final ModelAndView RequestErrorHandler(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("redirect:/");
    }      

}
