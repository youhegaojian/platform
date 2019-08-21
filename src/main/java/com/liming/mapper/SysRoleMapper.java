package com.liming.mapper;

import java.util.List;

import com.liming.domain.SysRole;
import com.liming.utils.MyMapper;

public interface SysRoleMapper extends MyMapper<SysRole> {

	List<SysRole> getRoleListByUsername(String username);
}