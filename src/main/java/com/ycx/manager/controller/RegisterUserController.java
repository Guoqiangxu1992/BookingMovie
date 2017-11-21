/**
 * 
 */
package com.ycx.manager.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ycx.manager.Dto.LoginUserDto;
import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.service.AccountService;
import com.ycx.manager.service.LoginUserService;
import com.ycx.manager.serviceImpl.AccountServiceImpl;
import net.sf.json.JSONObject;

/**
 * @author summer
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")

public class RegisterUserController extends BaseController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoginUserService loginUserService;

	@RequestMapping("/register.do")
	@ResponseBody
	public int userRegister(LoginUser loginUser, Model model,HttpSession session) throws RuntimeException {
		loginUser.setUserId(String.valueOf(System.currentTimeMillis()));
		loginUser.setPassword(MD5Util.convertMD5(loginUser.getPassword()));
		int result = accountService.saveUser(loginUser);
		session.setAttribute("SESSION_LOGIN_USER", loginUser);
		if (result == 1) {
			return 1;// 注册成功
		}
		return 0;

	}
	
	@RequestMapping("/addBackendUser.do")
	public ModelAndView addBackendUser(LoginUser loginUser, Model model,HttpSession session) throws RuntimeException {
		loginUser.setPassword("ycx520");
		loginUser.setMakeTime(new Date());
		loginUser.setUserId(String.valueOf(System.currentTimeMillis()));
		loginUser.setPassword(MD5Util.convertMD5(loginUser.getPassword()));
		accountService.addBackendUser(loginUser);
		return new ModelAndView("/system/user/user");
	}
	
	

	// 对用户密码加密，并且等到salt相当于盐
	public LoginUser getPasswordUser(LoginUser loginUser) {
		LoginUser loginUserReturn = AccountServiceImpl.encryptPassword(loginUser);
		loginUser.setPassword(loginUserReturn.getPassword());
		loginUser.setSalt(loginUserReturn.getSalt());
		return loginUser;
	}

	@RequestMapping("/salesUser.do")
	public ModelAndView userManagerView() {
		return new ModelAndView("/system/user/user");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loginUserList.do")
	@ResponseBody
	public String loginUserList( LoginUserDto loginUserDto) {
		JSONObject jsonResult = new JSONObject();
		List<LoginUserDto> LoginUserDtoList = null;
		if (loginUserDto != null) {
			try {
				loginUserDto.setLimit(loginUserDto.getPgLimit());
				loginUserDto.setPgNumber(loginUserDto.getPgCurrentPage());
				Pagination descOutsourcerpg = loginUserService.queryList(loginUserDto);
				if (descOutsourcerpg != null) {
					if (CollectionUtils.isNotEmpty(descOutsourcerpg.getResultList())) {
						LoginUserDtoList = descOutsourcerpg.getResultList();
					}
				}
				// 把数据装到jsonResult中
				jsonResult = com.ycx.manager.ClassUtil.JsonUtils.toGridJson(descOutsourcerpg.getTotalCount(),LoginUserDtoList);
				String json = jsonResult.toString();
				return json;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	@RequestMapping(value = "/customer.do")
	public ModelAndView customer() {
		return new ModelAndView("/system/user/customer");
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerList.do")
	@ResponseBody
	public String getCustomerList(@Param("loginUserDto") LoginUserDto loginUserDto) {
		JSONObject jsonResult = new JSONObject();
		List<LoginUserDto> LoginUserDtoList = null;
		if (loginUserDto != null) {
			try {
				loginUserDto.setLimit(loginUserDto.getPgLimit());
				loginUserDto.setPgNumber(loginUserDto.getPgCurrentPage());
				Pagination descOutsourcerpg = loginUserService.getCustomerList(loginUserDto);
				if (descOutsourcerpg != null) {
					if (CollectionUtils.isNotEmpty(descOutsourcerpg.getResultList())) {
						LoginUserDtoList = descOutsourcerpg.getResultList();
					}
				}
				// 把数据装到jsonResult中
				jsonResult = com.ycx.manager.ClassUtil.JsonUtils.toGridJson(descOutsourcerpg.getTotalCount(),LoginUserDtoList);
				String json = jsonResult.toString();
				return json;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	
	
	@RequestMapping("/editUserInfo.do")
	public ModelAndView editUserInfo(Model model,HttpSession session) {
		return new ModelAndView("/system/user/editUserInfo");
	}
	
	
	@RequestMapping("/updateUser.do")
	public void updateUser(@Param("loginUserDto") LoginUserDto loginUserDto,HttpSession session) {
		loginUserDto.setPassword(MD5Util.convertMD5(loginUserDto.getPassword()));
		loginUserService.updateUser(loginUserDto);
		LoginUser loginUser = (LoginUser) session.getAttribute("SESSION_LOGIN_USER");
		loginUser.setEmail(loginUserDto.getEmail());
		loginUser.setLoginName(loginUserDto.getLoginName());
		loginUser.setName(loginUserDto.getName());
		loginUser.setPassword(loginUserDto.getPassword());
		session.setAttribute("SESSION_LOGIN_USER", loginUser);
	}
	
	
	
}
