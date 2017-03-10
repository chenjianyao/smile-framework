package com.smileframework.admin.core.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudDao<T, ID extends Serializable> extends BaseDao {

	<S extends T> int insert(S entity);

	<S extends T> int insertSelective(S entity);

	<S extends T> int insertList(List<S> list);

	<S extends T> int updateByPrimaryKey(S entity);

	<S extends T> int updateByPrimaryKeySelective(S entity);

	void deleteByPrimaryKey(ID id);

	<S extends T> S selectByPrimaryKey(ID id);

	<S extends T> List<S> selectSelective(S entity);
}