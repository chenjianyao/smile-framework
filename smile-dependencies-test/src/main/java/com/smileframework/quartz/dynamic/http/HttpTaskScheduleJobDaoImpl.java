package com.smileframework.quartz.dynamic.http;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class HttpTaskScheduleJobDaoImpl implements HttpTaskScheduleJobDao {

	public static final String TABLE_NAME = "sys_task_schedule_job";

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public List<HttpTaskScheduleJob> queryHttpTaskScheduleJobList(HttpTaskScheduleJob jobCond) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" select * from ");
		sqlBuffer.append(TABLE_NAME);

		List<Object> paramList = new ArrayList<Object>();
		if (!(StringUtils.isEmpty(jobCond.getJobGroup()) && StringUtils.isEmpty(jobCond.getJobName())
				&& StringUtils.isEmpty(jobCond.getJobStatus()))) {

			sqlBuffer.append(" where 1=1 ");

			if (!StringUtils.isEmpty(jobCond.getJobGroup())) {
				paramList.add(jobCond.getJobGroup());
				sqlBuffer.append(" and job_group = ? ");
			}
			if (!StringUtils.isEmpty(jobCond.getJobName())) {
				paramList.add(jobCond.getJobName());
				sqlBuffer.append(" and job_name = ? ");
			}
			if (!StringUtils.isEmpty(jobCond.getJobStatus())) {
				paramList.add(jobCond.getJobStatus());
				sqlBuffer.append(" and job_status = ? ");
			}

		}
		final List<HttpTaskScheduleJob> list = jdbcTemplate.query(sqlBuffer.toString(),
				new HttpTaskScheduleJobRowMapper(), (Object[]) paramList.toArray(new Object[paramList.size()]));
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.citycloud.frame.task.dao.TaskScheduleJobDao#insert(cn.com.
	 * citycloud.frame.task.entity.TaskScheduleJob)
	 */
	@Override
	public int insert(final HttpTaskScheduleJob job) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" insert into ");
		sqlBuffer.append(TABLE_NAME);
		sqlBuffer.append(
				"(job_name, job_status, job_group, cron_expression, bean_class, spring_id, method_name, is_concurrent, description, create_time, update_time, prj_name)");
		sqlBuffer.append(" values (?,?,?,?,?,?,?,?,?,?,?,?) ");

		return jdbcTemplate.update(sqlBuffer.toString(), new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, job.getJobName());
				ps.setString(2, job.getJobStatus());
				ps.setString(3, job.getJobGroup());

				ps.setString(4, job.getCronExpression());

				ps.setTimestamp(10, new java.sql.Timestamp(job.getCreateTime().getTime()));
				ps.setTimestamp(11, new java.sql.Timestamp(job.getUpdateTime().getTime()));
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.citycloud.frame.task.dao.TaskScheduleJobDao#selectById(java.lang.
	 * Long)
	 */
	@Override
	public HttpTaskScheduleJob selectById(Long id) {
		final String sql = " select * from " + TABLE_NAME + " where id = ? ";
		final List<HttpTaskScheduleJob> list = jdbcTemplate.query(sql, new HttpTaskScheduleJobRowMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.citycloud.frame.task.dao.TaskScheduleJobDao#updateSelectiveById(cn
	 * .com.citycloud.frame.task.entity.TaskScheduleJob)
	 */
	@Override
	public int updateSelectiveById(final HttpTaskScheduleJob job) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" update ");
		sqlBuffer.append(TABLE_NAME);
		sqlBuffer.append(" set id = ?");
		if (!StringUtils.isEmpty(job.getJobGroup())) {
			sqlBuffer.append(" , job_group = ? ");
		}
		if (!StringUtils.isEmpty(job.getJobName())) {
			sqlBuffer.append(" , job_name = ? ");
		}
		if (!StringUtils.isEmpty(job.getJobStatus())) {
			sqlBuffer.append(" , job_status = ? ");
		}
		if (!StringUtils.isEmpty(job.getCronExpression())) {
			sqlBuffer.append(" , cron_expression = ? ");
		}
		if (job.getUpdateTime() != null) {
			sqlBuffer.append(" , update_time = ? ");
		}

		sqlBuffer.append(" where id = ?");

		return jdbcTemplate.update(sqlBuffer.toString(), new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, job.getId());
				ps.setString(3, job.getJobGroup());
				ps.setString(4, job.getJobName());
				ps.setString(5, job.getJobStatus());
				ps.setString(8, job.getCronExpression());
				ps.setTimestamp(11, new java.sql.Timestamp(job.getUpdateTime().getTime()));
				ps.setLong(12, job.getId());
			}
		});
	}

}

class HttpTaskScheduleJobRowMapper implements RowMapper<HttpTaskScheduleJob> {

	public HttpTaskScheduleJobRowMapper() {
	}

	@Override
	public HttpTaskScheduleJob mapRow(ResultSet rs, int rowNum) throws SQLException {
		HttpTaskScheduleJob httpTaskScheduleJob = new HttpTaskScheduleJob();
		httpTaskScheduleJob.setCronExpression(rs.getString("cron_expression"));
		httpTaskScheduleJob.setId(rs.getLong("id"));
		httpTaskScheduleJob.setJobGroup(rs.getString("job_group"));
		httpTaskScheduleJob.setJobName(rs.getString("job_name"));
		httpTaskScheduleJob.setJobStatus(rs.getString("job_status"));
		httpTaskScheduleJob.setCreateTime(rs.getTimestamp("create_time"));
		httpTaskScheduleJob.setUpdateTime(rs.getTimestamp("update_time"));
		return httpTaskScheduleJob;

	}
}
