package com.liming.mapper;

import com.liming.domain.UserInfo;
import com.liming.utils.MyMapper;

public interface UserInfoMapper extends MyMapper<UserInfo> {

	UserInfo getUserByUsername(String username);
	
}