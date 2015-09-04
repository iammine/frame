package com.gzy.frame.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzy.frame.common.redis.IRedisService;


@Controller
public class Test1Controller {
	@Autowired
	private IRedisService redisService;

	@RequestMapping("/index")
	public String toIndex(){
		this.redisService.setStr("name", "guozeyuan223344");
		System.out.println(this.redisService.getStr("name")+"*******************");
		return "index";
	}
}
