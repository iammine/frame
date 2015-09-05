package com.gzy.frame.common.validCode.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzy.frame.common.constants.CommonConstants;
import com.gzy.frame.common.redis.IRedisService;
import com.gzy.frame.common.util.CookieUtil;
import com.gzy.frame.common.util.ImageCodeUtil;
import com.gzy.frame.common.util.MakeUUID;
import com.gzy.frame.common.validCode.IValidCodeService;

@Service
public class ValidCodeServiceImpl implements IValidCodeService {
	@Autowired
	private IRedisService redisService;

	public void createValidCodeImage(HttpServletResponse response) {
		//调用工具类，生成图片跟验证码
		ImageCodeUtil imageCode = new ImageCodeUtil();
		BufferedImage image = imageCode.getImage(60, 20);
		String code = imageCode.getCode();
		
		//将生成的验证码放入redis
		String uuid = MakeUUID.getUUID();
		this.redisService.setStrExpiry(uuid, code, CommonConstants.COOKIE_EXPIRY);
		CookieUtil.addCookie(response, CommonConstants.COOKIE_VALIDE_CODE_NAME, uuid, CommonConstants.COOKIE_EXPIRY);
		
		OutputStream os = null;
		try{
			os = response.getOutputStream();
			//写图片
			ImageIO.write(image, "jpeg", os);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				os.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}	
	}

	public String getValidCodeStr(HttpServletRequest request) {
		String validCodeRedisName = CookieUtil.getCookieValueByName(request, CommonConstants.COOKIE_VALIDE_CODE_NAME);
		return this.redisService.getStr(validCodeRedisName);
	}

}
