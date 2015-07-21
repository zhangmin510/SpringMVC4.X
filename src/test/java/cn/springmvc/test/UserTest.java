package cn.springmvc.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;



public class UserTest {

private UserService userService;
	
	@Before
	public void before(){                                                                    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		userService = (UserService) context.getBean("userServiceImpl");
	}
	
//	@Test
//	public void addUser(){
//		User user = new User();
//		user.setEmail("te@zhangmin.name");
//		user.setName("zm");
//		user.setPasswd("lllll");
//		System.out.println(userService.insertUser(user));
//	}
//	
	@Test
	public void getUserById() {
		User u = userService.getUserById(1);
		assertEquals("name not match", "zm", u.getName());
	}
	
	@Test
	public void getAllUser() {
		List<User> us = userService.getAllUser();
		for (User u : us) {
			System.out.println(u.getEmail());
		}
	}
}
