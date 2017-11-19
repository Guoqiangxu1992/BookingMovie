package com.ycx.manager.framework;

import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.RegisterUser;

/**
* @author Create By Yangchunxue
* @date   2016年12月6日--下午8:48:54--
*
*/
public class SessionBagImpl implements SessionBag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8332611263852138962L;
	
	private LoginUser loginUser;

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}


}
