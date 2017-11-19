/**
 * 
 */
package com.ycx.manager.dao;

import org.apache.ibatis.annotations.Param;

import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.RegisterUser;

/**
* @author Create By Yangchunxue
* @date   2016年8月2日--下午9:31:10--
*
*/
/**
 * @author summer
 *
 */
public interface AccountDao {

	/**
	 * @param register 
	 * @return
	 */
	public int insertRegister(RegisterUser register);

	/**
	 * @param loginUser
	 * @return
	 */
	public int insertLoginUser(LoginUser loginUser);

	/**
	 * @param id
	 * @return
	 */
	public int insertLoginUserRole(Integer id);

	/**
	 * @param loginUser
	 * @return
	 */
	public int insertLoginUserRole(LoginUser loginUser);

	public int addBackendUser(@Param("loginUser") LoginUser loginUser);

}
