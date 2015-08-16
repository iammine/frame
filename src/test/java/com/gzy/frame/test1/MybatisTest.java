package com.gzy.frame.test1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gzy.frame.test1.mapper.UserMapper;
import com.gzy.frame.test1.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_mybatis.xml"})
public class MybatisTest {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private UserMapper userMapper;
	
	/**
	 * test connect
	 */
	@Test
	public void testMybatisConnect(){
		User user = this.userMapper.getUserById();
		System.out.println(user.getNicke());
	}
}
