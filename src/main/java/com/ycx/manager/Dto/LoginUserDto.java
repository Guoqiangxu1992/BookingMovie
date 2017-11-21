/**
 * 
 */
package com.ycx.manager.Dto;

import java.util.Date;

/**
* @author Create By Yangchunxue
* @date   2016年8月7日--下午6:27:10--
*
*/

public class LoginUserDto extends BaseDto{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2149586613058930325L;
	private String loginName;
	private String roleId;
   private Date startTime;
	private Date endTime;
	private String userId;
	private String email;
	private String password;
	private String phone;
	private String name;

	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
