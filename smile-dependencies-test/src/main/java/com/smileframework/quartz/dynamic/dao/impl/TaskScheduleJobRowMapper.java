package com.smileframework.quartz.dynamic.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smileframework.quartz.dynamic.entity.TaskScheduleJob;

public class TaskScheduleJobRowMapper implements RowMapper<TaskScheduleJob> {

    public TaskScheduleJobRowMapper() {
    }

    @Override
    public TaskScheduleJob mapRow(ResultSet rs, int rowNum) throws SQLException {
        TaskScheduleJob taskScheduleJob=new TaskScheduleJob();
        taskScheduleJob.setBeanClass(rs.getString("bean_class"));
        taskScheduleJob.setCreateTime(rs.getTimestamp("create_time"));
        taskScheduleJob.setCronExpression(rs.getString("cron_expression"));
        taskScheduleJob.setDescription(rs.getString("description"));
        taskScheduleJob.setId(rs.getLong("id"));
        taskScheduleJob.setIsConcurrent(rs.getString("is_concurrent"));
        taskScheduleJob.setJobGroup(rs.getString("job_group"));
        taskScheduleJob.setJobName(rs.getString("job_name"));
        taskScheduleJob.setJobStatus(rs.getString("job_status"));
        taskScheduleJob.setMethodName(rs.getString("method_name"));
        taskScheduleJob.setPrjName(rs.getString("prj_name"));
        taskScheduleJob.setSpringId(rs.getString("spring_id"));
        taskScheduleJob.setUpdateTime(rs.getTimestamp("update_time"));
        return taskScheduleJob;

    }
}
