package com.smile.admin.dao;

import java.util.List;
import java.util.Map;

import com.smile.admin.model.entity.TblUser;

public interface TblUserMapper {
	int deleteByPrimaryKey(String id);

	int insert(TblUser record);

	TblUser selectByPrimaryKey(String id);

	int updateByPrimaryKey(TblUser record);

	List<TblUser> select(Map<String, String> map);
}