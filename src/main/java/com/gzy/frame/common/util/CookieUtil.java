/**
 * 
 */
package com.gzy.frame.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * cookie工具类
 */
public class CookieUtil {
	/**
	 * 添加cookie
	 * @param response
	 * @param name ： cookie名
	 * @param value ： cookie的值
	 * @param path ： cookie的路径
	 * @param domain ： cookie的域
	 * @param expiry ： cookie的过期时间
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, String path, String domain, int expiry){
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain(domain);
		cookie.setPath(path);
		if(expiry >= 0){
			cookie.setMaxAge(expiry);
		}else{
			cookie.setMaxAge(-1);
		}
		response.addCookie(cookie);
	}
	
	/**
	 * 添加cookie
	 * @param response
	 * @param name ： cookie名
	 * @param value ： cookie的值
	 * @param expiry ： cookie的过期时间
	 */
	public static void addCookie(HttpServletResponse response, String name, String value, int expiry){
		try{
			Cookie cookie = new Cookie(name, value);
			/*cookie.setDomain("localhost:8080");*/
			cookie.setPath("/");
			if(expiry >= 0){
				cookie.setMaxAge(expiry);
			}else{
				cookie.setMaxAge(-1);
			}
			response.addCookie(cookie);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除cookie
	 * @param response
	 * @param name ： cookie的名称
	 */
	public static void deleteCookie(HttpServletResponse response, String name){
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	/**
	 * 通过cookie的name，获取cookie的value
	 * @param request
	 * @param name ： cookie的name
	 * @return
	 */
	public static String getCookieValueByName(HttpServletRequest request, String name){
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie : cookies){
				if(name.equals(cookie.getName())){
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
