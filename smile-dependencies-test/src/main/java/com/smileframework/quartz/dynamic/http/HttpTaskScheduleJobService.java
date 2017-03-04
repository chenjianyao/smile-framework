package com.smileframework.quartz.dynamic.http;

import java.util.List;

/**
 *
 * HttpTaskScheduleJob 表数据服务层接口
 *
 */
public interface HttpTaskScheduleJobService {

	List<HttpTaskScheduleJob> queryAllRunningJob(String appName);

	List<HttpTaskScheduleJob> queryHttpTaskScheduleJobList(HttpTaskScheduleJob httpTaskScheduleJob);

	void updateSelectiveById(HttpTaskScheduleJob httpTaskScheduleJob);

	HttpTaskScheduleJob selectById(Long id);

	void addTask(HttpTaskScheduleJob httpTaskScheduleJob);

	HttpTaskScheduleJob changeStatus(Long id, String cmd);

	HttpTaskScheduleJob updateCron(HttpTaskScheduleJob httpTaskScheduleJob);
}