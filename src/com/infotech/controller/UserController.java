package com.infotech.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

	
	@RequestMapping(value="/user/{userName}/{age}", method=RequestMethod.GET)
	public ModelAndView greet(@PathVariable("userName")String userName,@PathVariable("age")int age, @RequestParam("country")String country){
		return new ModelAndView("welcomePage","welcomeMessage", "Hello "+userName+" you are "+age+" years old, you are from "+country);
	} 
	
	/*
	if pathvariable contains more than one period symbols it took upto only one priod, to overcome
	that error we use :.+
	*/
	@RequestMapping(value="/domain/{domainName:.+}")
	public ModelAndView greet(@PathVariable("domainName")String domainName){
		return new ModelAndView("welcomePage","welcomeMessage", "Hello "+domainName);
	} 
	
	/*
	 * using map collecting path variables
	 */
	
	@RequestMapping(value="/user/{userName}/{age}/{userId}", method=RequestMethod.GET)
	public ModelAndView greet(@PathVariable Map<String, String> pathsMap){
		String userName = pathsMap.get("userName");
		int age = Integer.parseInt(pathsMap.get("age"));
		String userId = pathsMap.get("userId");
		return new ModelAndView("welcomePage","welcomeMessage", "Hello "+userName+" you are "+age+" years old, your id is "+userId);
	}
}

