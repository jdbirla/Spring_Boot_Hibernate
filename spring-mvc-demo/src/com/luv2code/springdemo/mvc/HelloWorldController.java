package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller init form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need for process form
	@RequestMapping("/processForm")
	public String procForm() {
		return "helloworld";
	}

	// new method to read data form adn add to model
	@RequestMapping("/processFormVersionTwo")
	public String lestShoutDude(HttpServletRequest req, Model model) {
		String theName = req.getParameter("studentName");
		theName = theName.toUpperCase();

		String res = "Yo!" + theName;

		model.addAttribute("message", res);

		return "helloworld";
	}
	
	
	// new method to read data form adn add to model
		@RequestMapping("/processFormVersionThree")
		public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
			
			theName = theName.toUpperCase();

			String res = "Hey my frnd !" + theName;

			model.addAttribute("message", res);

			return "helloworld";
		}

}
