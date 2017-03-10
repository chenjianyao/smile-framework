/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.smileframework.admin.core.service;

import java.util.List;

public interface BaseService<T> {

	public T findOne(Long id);

	public List<T> findList(T entity);

	public void delete(Long id);

	public int insert(T entity);

	public int insertList(List<T> list);

	public int insertSelective(T entity);

	public int updateByPrimaryKey(T entity);

	public int updateByPrimaryKeySelective(T entity);

	public int saveOrUpdate(T entity);

	public int saveOrUpdateSelective(T entity);

}
