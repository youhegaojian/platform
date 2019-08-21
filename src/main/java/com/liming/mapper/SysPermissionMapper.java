package com.liming.mapper;

import java.util.List;

import com.liming.domain.SysPermission;
import com.liming.utils.MyMapper;

public interface SysPermissionMapper extends MyMapper<SysPermission> {

	List<SysPermission> getPermissions(String role_id);

    List<SysPermission> getPermissions(Integer uid);


}