package com.smileframework.quartz.simple;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @author chenjian
 * @since 2017年3月4日 下午2:31:34
 */
public class SecondScheduledJob extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(SecondScheduledJob.class);


	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("I am SecondScheduledJob");
	}
}