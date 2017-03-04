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

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时任务运行工厂类 增加注解@DisallowConcurrentExecution表示有状态JOB
 * 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * 
 * @author chenjian
 * @since 2017年3月4日 下午4:04:35
 */
@DisallowConcurrentExecution
public class HttpQuartzJobFactoryDisallowConcurrentExecution implements Job {
	private static final Logger logger = LoggerFactory.getLogger(HttpQuartzJobFactoryDisallowConcurrentExecution.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("任务成功运行");
		HttpTaskScheduleJob scheduleJob = (HttpTaskScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		logger.info("任务名称 = [" + scheduleJob.getJobName() + "]");
		// TODO 异步发送HTTP请求?
	}
}