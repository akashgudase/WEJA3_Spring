package com.jspiders.smswithspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(path = "/add_student", method = RequestMethod.GET)
	public String getPageToAddStudent() {
		return "add_student";
	}

}
