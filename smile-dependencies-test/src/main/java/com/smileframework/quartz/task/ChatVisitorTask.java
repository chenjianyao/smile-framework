package com.smileframework.quartz.task;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author chenjian
 * @since 2017年3月4日 下午3:44:04
 */
@Component
public class ChatVisitorTask {
	private static final Logger logger = LoggerFactory.getLogger(ChatVisitorTask.class);

	/**
	 * 访客统计——在线时长分类统计、各类在线人数统计
	 */
	@Scheduled(cron = "0/10 * * ? * *")
	public void statVisitorsDay() {
		if (TaskManager.off()) {
			return;
		}
		logger.info("statVisitorsDay task begin");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date loc_endTime = calendar.getTime();
		calendar.add(Calendar.DATE, -1);
		Date loc_startTime = calendar.getTime();
		logger.info("statVisitorsDay task end");
	}
}
