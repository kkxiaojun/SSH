package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {
	
	@RequestMapping(value="/index", method = {RequestMethod.GET})
    public ModelAndView index(){
		
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("message", "Hello World!");  
		modelAndView.setViewName("index");  
        return modelAndView;
    }
}
