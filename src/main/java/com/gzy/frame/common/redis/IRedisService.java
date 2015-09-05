/**
 * 
 */
package com.gzy.frame.common.redis;

/**
 * @author Administrator
 *	redis 服务
 */
public interface IRedisService {
	public boolean setStr(String key, String value);
	
	public boolean setStrExpiry(String key, String value, int expiry);
	
	public String getStr(String key);
}
