/**
 * 
 */
package com.ycx.manager.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.ycx.manager.Dto.LoginUserDto;
import com.ycx.manager.bean.LoginUser;

/**
* @author Create By Yangchunxue
* @date   2016年7月26日--下午2:53:11--
*
*/
public interface LoginUserDao {

	/**
	 * @param username 
	 * @return
	 */
	public LoginUser findUserByUsername(@Param("username")String username);

	/**
	 * @param loginName
	 * @return
	 */
	public Set<String> findRoleByName(String loginName);

	/**
	 * @param loginName
	 * @return
	 */
	public Set<String> findPermissionByName(String loginName);

	/**
	 * @param loginUserDto
	 * @return
	 */
	public List<LoginUser> queryList(@Param("loginUserDto")LoginUserDto loginUserDto);

	/**
	 * @param loginUserDto
	 * @return
	 */
	public int countQueryList(@Param("loginUserDto")LoginUserDto loginUserDto);

	public int countGetCustomerList(@Param("loginUserDto")LoginUserDto loginUserDto);

	public List<LoginUser> getCustomerList(@Param("loginUserDto")LoginUserDto loginUserDto);

	public LoginUser findReceptionUserByUsername(@Param("username")String username);

}
