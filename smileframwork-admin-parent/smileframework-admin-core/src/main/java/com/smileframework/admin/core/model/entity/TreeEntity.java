package com.smileframework.admin.core.model.entity;

public abstract class TreeEntity<T> extends AuditEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = -4922177483601046723L;

	protected T parent; // 父级

	private String parentIds; // 所有父级编号
	private Long parentId;

	abstract public T getParent();

	abstract public void setParent(T parent);

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
