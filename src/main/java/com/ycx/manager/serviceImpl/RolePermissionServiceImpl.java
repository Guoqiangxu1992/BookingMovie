package com.ycx.manager.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycx.manager.bean.RolePermissionTreeVo;
import com.ycx.manager.dao.RolePermissionDao;
import com.ycx.manager.service.RolePermissionService;

/**
* @author Create By Yangchunxue
* @date   2016年12月4日--下午4:02:08--
*
*/
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService{
     
	@Autowired
	private RolePermissionDao rolePermissionDao;
	
	@Override
	public List<RolePermissionTreeVo> getRolePermission() {
		return rolePermissionDao.getRolePermission();
	}

	@Override
	public List<Map<String, Object>> getRoles() {
		return rolePermissionDao.getRoles();
	}

}
