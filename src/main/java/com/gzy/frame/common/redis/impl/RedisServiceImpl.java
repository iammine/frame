package com.gzy.frame.common.redis.impl;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.gzy.frame.common.redis.IRedisService;

@Service
public class RedisServiceImpl implements IRedisService {
	private static JedisPool jedisPool;
	public static JedisPool getJedisPool(){
		if(jedisPool == null){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(5);
			config.setMaxWaitMillis(1000*5);
			config.setMaxTotal(500);
			return new JedisPool(config, "192.168.85.130");
		}
		return jedisPool;
	}
	

	public boolean setStr(String key, String value) {
		Jedis jedis = getJedisPool().getResource();
		jedis.set(key, value);
		return true;
	}

	public String getStr(String key) {
		Jedis jedis = getJedisPool().getResource();
		return jedis.get(key);
	}
	
	
}
