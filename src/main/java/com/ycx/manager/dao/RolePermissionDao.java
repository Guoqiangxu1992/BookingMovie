package com.ycx.manager.dao;

import java.util.List;
import java.util.Map;

import com.ycx.manager.bean.RolePermissionTreeVo;

/**
* @author Create By Yangchunxue
* @date   2016年12月4日--下午4:03:54--
*
*/
public interface RolePermissionDao {

	public List<RolePermissionTreeVo> getRolePermission();

	public List<Map<String, Object>> getRoles();

}
