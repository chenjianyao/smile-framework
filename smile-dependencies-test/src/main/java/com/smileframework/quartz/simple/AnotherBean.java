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
 * @since 2017年3月4日 下午2:31:03
 */
@Component("anotherBean")
public class AnotherBean {
	private static final Logger logger = LoggerFactory.getLogger(AnotherBean.class);

	public void printAnotherMessage() {
		logger.info("I am AnotherBean. I am called by Quartz jobBean using CronTriggerFactoryBean");
	}

}
