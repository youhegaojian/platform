package com.liming.service;

import java.util.List;

import com.liming.domain.SysPermission;
import com.liming.domain.UserInfo;

/**
* Copyright: Copyright (c) 2019 liming
* 
* @Description: 该类的功能描述
* @author: ALPHA.GJ.
* @date: 2019年7月4日 下午4:32:49 
 */
public interface UserInfoService {

	public UserInfo findByUsername(String username);
	
	public List<SysPermission> getPermissions(String role_id);

	public List<SysPermission> getPermissions(Integer uid);

}
