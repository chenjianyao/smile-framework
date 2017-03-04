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
package com.smileframework.quartz.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @author chenjian
 * @since 2017年3月4日 下午2:30:14
 */
@Component("myBean")
public class MyBean {
	private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

	public void printMessage() {
		logger.info("I am MyBean. I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
	}

}