package com.liming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.liming.domain.SysPermission;
import com.liming.domain.SysRole;
import com.liming.domain.UserInfo;
import com.liming.mapper.SysPermissionMapper;
import com.liming.mapper.SysRoleMapper;
import com.liming.mapper.UserInfoMapper;
import com.liming.service.UserInfoService;

/**
 * Copyright: Copyright (c) 2019 liming
 * 
 * @Description: 该类的功能描述
 * @author: ALPHA.GJ.
 * @date: 2019年7月4日 下午4:33:22
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private SysPermissionMapper permissionMapper;

	@Override
	@Cacheable(value = "user", key = "#username")//3
	public UserInfo findByUsername(String username) {

		UserInfo user = userMapper.getUserByUsername(username);
		List<SysRole> roleList = roleMapper.getRoleListByUsername(username);
		user.setRoleList(roleList);
		return user;
	}

	@Override
	public List<SysPermission> getPermissions(String role_id) {
		
		List<SysPermission> permissions = permissionMapper.getPermissions(role_id);
		return permissions;
	}

	@Override
	public List<SysPermission> getPermissions(Integer uid) {
		List<SysPermission> permissions = permissionMapper.getPermissions(uid);
		return permissions;
	}

}
