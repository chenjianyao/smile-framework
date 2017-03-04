package com.smileframework.quartz.dynamic.http;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * 
 * TaskScheduleJob 表数据服务层接口实现类
 * 
 */
@Service
public class HttpTaskScheduleJobServiceImpl implements HttpTaskScheduleJobService {

	@Resource
	private HttpTaskScheduleJobDao httpTaskScheduleJobDao;

	@Override
	public void addTask(HttpTaskScheduleJob job) {
		HttpTaskScheduleJob jobCond = new HttpTaskScheduleJob();
		jobCond.setJobName(job.getJobName());
		jobCond.setJobGroup(job.getJobGroup());
		// jobCond.setPrjName(job.getPrjName());
		List<HttpTaskScheduleJob> list = httpTaskScheduleJobDao.queryHttpTaskScheduleJobList(jobCond);
		if (list != null && list.size() > 0) {
			throw new RuntimeException("name group 组合有重复！");
		}
		job.setCreateTime(new Date());
		httpTaskScheduleJobDao.insert(job);
	}

	@Override
	public HttpTaskScheduleJob changeStatus(Long jobId, String cmd) {
		HttpTaskScheduleJob job = httpTaskScheduleJobDao.selectById(jobId);
		if (job == null) {
			throw new RuntimeException("没有查询到相应的任务");
		}
		job.setUpdateTime(new Date());
		if ("stop".equals(cmd)) {
			job.setJobStatus(HttpJobEnum.ScheduleJobStatus.STATUS_NOT_RUNNING.getCode());
		} else if ("start".equals(cmd)) {
			job.setJobStatus(HttpJobEnum.ScheduleJobStatus.STATUS_RUNNING.getCode());
		}
		httpTaskScheduleJobDao.updateSelectiveById(job);
		return job;
	}

	@Override
	public HttpTaskScheduleJob updateCron(HttpTaskScheduleJob taskScheduleJob) {
		HttpTaskScheduleJob job = httpTaskScheduleJobDao.selectById(taskScheduleJob.getId());
		if (job == null) {
			throw new RuntimeException("没有查询到相应的任务");
		}
		job.setUpdateTime(new Date());
		job.setCronExpression(taskScheduleJob.getCronExpression());
		httpTaskScheduleJobDao.updateSelectiveById(job);
		return job;
	}

	@Override
	public List<HttpTaskScheduleJob> queryAllRunningJob(String prjName) {
		HttpTaskScheduleJob httpTaskScheduleJob = new HttpTaskScheduleJob();
		httpTaskScheduleJob.setJobStatus(HttpJobEnum.ScheduleJobStatus.STATUS_RUNNING.getCode());
		return httpTaskScheduleJobDao.queryHttpTaskScheduleJobList(httpTaskScheduleJob);
	}

	@Override
	public HttpTaskScheduleJob selectById(Long jobId) {
		return httpTaskScheduleJobDao.selectById(jobId);
	}

	@Override
	public void updateSelectiveById(HttpTaskScheduleJob scheduleJob) {
		httpTaskScheduleJobDao.updateSelectiveById(scheduleJob);
	}

	@Override
	public List<HttpTaskScheduleJob> queryHttpTaskScheduleJobList(HttpTaskScheduleJob taskScheduleJob) {
		return httpTaskScheduleJobDao.queryHttpTaskScheduleJobList(taskScheduleJob);
	}

}