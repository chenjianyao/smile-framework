package com.smileframework.admin.core.dao;

import java.util.List;

import com.smileframework.admin.core.model.entity.BaseEntity;

public interface TreeDao<T extends BaseEntity> extends CrudDao<T, Long> {
	/**
	 * 找到所有子节点
	 *
	 * @param entity
	 *
	 * @return
	 */
	public List<T> findByParentIdsLike(T entity);

	/**
	 * 更新所有父节点字段
	 *
	 * @param entity
	 *
	 * @return
	 */
	public int updateParentIds(T entity);
}
