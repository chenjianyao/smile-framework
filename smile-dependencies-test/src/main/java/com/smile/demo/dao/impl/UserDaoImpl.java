package com.smile.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.smile.demo.dao.UserDao;
import com.smile.demo.entity.User;

/**
 * TODO(描述类的职责)
 * 
 * @author chenjian
 * @since 2016年12月30日 下午4:52:47
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(User user) {
		return user;
	}

}
