package com.management.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value={"", "/", "/StudentManagement"})
public class NavController {
	private ModelAndView modelAndView = new ModelAndView();

	@GetMapping("/help")
	public ModelAndView help() {
		modelAndView.setViewName("help");

		return modelAndView;
	}
	
	@GetMapping("/news")
	public ModelAndView news() {
		modelAndView.setViewName("news");

		return modelAndView;
	}
	
	@GetMapping("/contacts")
	public ModelAndView contacts() {
		modelAndView.setViewName("contacts");
		
		return modelAndView;
	}
}
