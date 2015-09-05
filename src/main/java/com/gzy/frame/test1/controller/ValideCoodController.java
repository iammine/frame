/**
 * 
 */
package com.gzy.frame.test1.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzy.frame.common.validCode.IValidCodeService;

/**
 * @author Administrator
 *
 */
@Controller
public class ValideCoodController {
	@Autowired
	private IValidCodeService validCodeService;
	
	@RequestMapping("code")
	public void getValideCode(HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = new Cookie("guo", "zeyuan");
		response.addCookie(cookie);
		this.validCodeService.createValidCodeImage(response);
		System.out.println("***********"+this.validCodeService.getValidCodeStr(request));
	}
}
