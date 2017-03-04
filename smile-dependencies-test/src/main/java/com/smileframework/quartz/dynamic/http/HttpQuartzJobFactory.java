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
package com.smileframework.quartz.dynamic.http;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smileframework.quartz.simple.AnotherBean;

/**
 * 定时任务运行工厂类 无状态JOB
 * 
 * @author chenjian
 * @since 2017年3月4日 下午3:15:31
 */
public class HttpQuartzJobFactory implements Job {
	private static final Logger logger = LoggerFactory.getLogger(AnotherBean.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("任务成功运行");
		HttpTaskScheduleJob scheduleJob = (HttpTaskScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		logger.info("任务名称 = [" + scheduleJob.getJobName() + "]");
		// TODO 异步发送HTTP请求?
	}
}