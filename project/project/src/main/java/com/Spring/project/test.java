package com.Spring.project;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody
public class test {

	@RequestMapping("/")
	public String home(){
		// TODO Auto-generated method stub
		System.out.println("This Is My Home Page");
      return "home";
	}

}
