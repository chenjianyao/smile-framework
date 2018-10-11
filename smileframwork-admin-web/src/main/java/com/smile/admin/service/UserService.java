package com.smile.admin.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.smile.admin.model.entity.TblUser;

/**
 * 
 * @author chenjian
 * @since 2017年3月10日 下午8:06:01
 */
public interface UserService {

	int deleteByPrimaryKey(String id);

	int insert(TblUser record);

	TblUser selectByPrimaryKey(String id);

	int updateByPrimaryKey(TblUser record);

	PageInfo<TblUser> select(Map<String, String> map);
}
