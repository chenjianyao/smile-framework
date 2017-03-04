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
package com.smile.demo.test.other;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.smileframework.common.date.DateUtils;

/**
 * 
 * @author chenjian
 * @since 2017年3月3日 下午12:58:35
 */
@RunWith(JUnit4.class)
public class DateUtilsTest {

	@Test
	public void getDate() {
		System.out.println(DateUtils.getDateTime());
	}

}
