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
package com.smileframework.quartz.task;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 定时任务管理
 * 
 * @author chenjian
 * @since 2017年3月4日 下午3:41:26
 */
public class TaskManager {
	private static final boolean QUARTZ_SWITCH_ON = true;

	/*
	 * private static final boolean QUARTZ_SWITCH_ON = "true"
	 * .equalsIgnoreCase(PropertiesLoaderUtils.loadAllProperties("ss").
	 * getProperty("quartzSwitchOn"));
	 */
	/**
	 * 判断定时任务开关
	 * 
	 * @return
	 */
	public static boolean on() {
		return QUARTZ_SWITCH_ON;
	}

	/**
	 * 判断定时任务开关
	 * 
	 * @return
	 */
	public static boolean off() {
		return !QUARTZ_SWITCH_ON;
	}
}
