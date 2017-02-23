/*
 * Copyright by mobanker and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about mobanker from
 *
 *      http://www.mobanker.com/
 *
 */
package com.smile.demo.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.smile.demo.custom.CustomUserValidation;
import com.smile.demo.dao.UserDao;
import com.smile.demo.entity.User;
import com.smile.demo.service.UserService;

/**
 * 
 * @author chenjian
 * @since 2016年12月30日 下午4:51:48
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	private UserDao userDao;
	@Resource
	private CustomUserValidation customUserValidation;
	
	@Override
	public User getUser(User user) {
		Errors errors = new BeanPropertyBindingResult(user, user.getClass().getName());
		//ValidationUtils.invokeValidator(customUserValidation, user, errors);
		
		LOGGER.info("UserServiceImpl.getUser 执行开始");
		
		return userDao.getUser(user);
	}

}
