/**
 * 
 */
package com.gzy.frame.common.validCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * 验证码服务
 */
public interface IValidCodeService {
	/**
	 * 生成验证码图片
	 * @param response
	 */
	public void createValidCodeImage(HttpServletResponse response);
	
	/**
	 * 获取验证码图片字符串
	 * @param request
	 * @return
	 */
	public String getValidCodeStr(HttpServletRequest request);
}
