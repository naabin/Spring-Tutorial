package com.nabin.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		theName.toUpperCase();
		String message = "Yo! "+ theName;
		model.addAttribute("message", message );
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(Model model, @RequestParam("studentName") String theName) {
		theName.toUpperCase();
		String message = "Hey my Friend from v3! "+ theName;
		model.addAttribute("message", message );
		return "helloworld";
	}
}
