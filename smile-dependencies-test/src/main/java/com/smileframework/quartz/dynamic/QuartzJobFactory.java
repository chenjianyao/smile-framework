package com.smileframework.quartz.dynamic;

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
public class QuartzJobFactory implements Job {
	private static final Logger logger = LoggerFactory.getLogger(AnotherBean.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("任务成功运行");
		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
		logger.info("任务名称 = [" + scheduleJob.getJobName() + "]");

	}
}