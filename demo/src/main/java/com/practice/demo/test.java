package com.practice.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class test {

	@RequestMapping("/test")
    @ResponseBody
	public String firstHand(){
		// TODO Auto-generated method stub
      return "just for testing";
	}

}
