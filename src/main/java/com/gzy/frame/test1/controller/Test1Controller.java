package com.gzy.frame.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Test1Controller {

	@RequestMapping("/index")
	public String toIndex(){
		return "index";
	}
}
