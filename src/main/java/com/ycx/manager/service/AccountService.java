/**
 * 
 */
package com.ycx.manager.service;

import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.RegisterUser;

/**
* @author Create By Yangchunxue
* @date   2016年7月31日--下午3:44:48--
*
*/

public interface AccountService {
	
	/**
	 * 保存新建用户以及其角色
	 * @param LoginUser
	 * @param 
	 * @author  
	 */

	/**
	 * @param register
	 * @return
	 */
	public int saveUser(LoginUser loginUser);

	public int addBackendUser(LoginUser loginUser);

}
