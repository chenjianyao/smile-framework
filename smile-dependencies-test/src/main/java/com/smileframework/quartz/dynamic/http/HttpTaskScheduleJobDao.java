package com.smileframework.quartz.dynamic.http;

import java.util.List;

/**
 * HttpTaskScheduleJob Dao
 *
 */
public interface HttpTaskScheduleJobDao {

	/**
	 * 根据指定的条件查询任务列表
	 *
	 * @param jobCond
	 * @return
	 */
	List<HttpTaskScheduleJob> queryHttpTaskScheduleJobList(HttpTaskScheduleJob job);

	/**
	 * 新增任务
	 *
	 * @param job
	 * @return
	 */
	int insert(HttpTaskScheduleJob job);

	/**
	 * 根据主键查询单条任务
	 *
	 * @param id
	 * @return
	 */
	HttpTaskScheduleJob selectById(Long id);

	/**
	 * 根据主键条件更新任务
	 *
	 * @param job
	 * @return
	 */
	int updateSelectiveById(HttpTaskScheduleJob job);

}
