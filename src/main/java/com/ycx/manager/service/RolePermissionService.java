package com.ycx.manager.service;

import java.util.List;
import java.util.Map;

import com.ycx.manager.bean.RolePermissionTreeVo;

/**
* @author Create By Yangchunxue
* @date   2016年12月4日--下午3:55:34--
*
*/
public interface RolePermissionService {

	public List<RolePermissionTreeVo> getRolePermission();

	public List<Map<String, Object>> getRoles();

}
