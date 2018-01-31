package com.wantdo.service;

import com.wantdo.entity.User;
import com.wantdo.entity.UserExample;
import com.wantdo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jinxl
 * @version 1.0 on 2018/1/30
 */
@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	public Object getAll() {
		return userMapper.selectByExample(new UserExample());
	}

	public Object getAllTest() {
		return userMapper.countByExample(new UserExample());
	}

	// @Transactional(rollbackFor = Exception.class)
	// 开启事务会报错
	public Object insert(String name) {
		User user = new User();
		user.setName(name);
		return userMapper.insert(user);
	}

	public Object insertS(String name) {
		User user = new User();
		user.setName(name);
		return userMapper.insertSelective(user);
	}
}
