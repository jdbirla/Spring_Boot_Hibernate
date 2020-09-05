package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		Student theStudent = new Student();
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent)
	{
		
		System.out.println("The Student: "+theStudent.getFirstName());
		String[]  arr = theStudent.getOs();
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.println("The Student os: "+arr[i]);

		}

		return "student-confirmation";
	}
}
