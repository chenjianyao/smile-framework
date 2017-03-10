/*
 * Copyright by mobanker and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about mobanker from
 *
 *      http://www.mobanker.com/
 *
 */
package com.smile.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smile.admin.dao.TblUserMapper;
import com.smile.admin.model.entity.TblUser;
import com.smile.admin.service.UserService;

/**
 * 
 * @author chenjian
 * @since 2017年3月10日 下午8:06:31
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private TblUserMapper tblUserMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return 0;
	}

	@Override
	public int insert(TblUser record) {
		return 0;
	}

	@Override
	public TblUser selectByPrimaryKey(String id) {
		return tblUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(TblUser record) {
		return 0;
	}

	@Override
	public PageInfo<TblUser> select(Map<String, String> map) {
		PageHelper.startPage(1, 20);
		List<TblUser> list = tblUserMapper.select(map);

		return new PageInfo<>(list);
	}

}
