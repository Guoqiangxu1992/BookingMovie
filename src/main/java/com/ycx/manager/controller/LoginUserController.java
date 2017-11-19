/**
 * 
 */
package com.ycx.manager.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.framework.SessionBagImpl;
import com.ycx.manager.framework.XgqSessionBag;
import com.ycx.manager.service.LoginUserService;

/**
* @author Create By Yangchunxue
* @date   2016年7月27日--上午10:50:40--
*
*/
/**
 * @author summer
 *
 */
@Controller
@RequestMapping("login")
@Scope("prototype")
public class LoginUserController {
	@Autowired
	private LoginUserService loginUserService;

	@SuppressWarnings("unused")
	@RequestMapping("/loginAjax.do")
	@ResponseBody
	public int info(@Param("username") String username, @Param("password") String password, Model model,
			HttpSession session, HttpServletRequest request) {
		try {
			String sessionId = session.getId();
			Cookie[] cookies = request.getCookies();

			String appName = "SECOND_HAND_CAR_MANAGER";
			String RequestId = appName + sessionId;
			String jsonId = appName + cookies[0].getValue();
			LoginUser user = new LoginUser();
			user = loginUserService.findUserByUsername(username);
			session.setAttribute("SESSION_LOGIN_USER", user);
			model.addAttribute("user", user);
			/*Subject subject = SecurityUtils.getSubject();
			subject.login(new UsernamePasswordToken(username, password));*/
			String passwordtemp = MD5Util.convertMD5(password);
			if (passwordtemp.equals(user.getPassword())) {
				return 1;
			} else {
				return 0;// 密码或者用户名错误
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//前台登录判断
	@RequestMapping("/ReceptionloginAjax.do")
	@ResponseBody
	public int ReceptionloginAjax(@Param("username") String username, @Param("password") String password, Model model,
			HttpSession session, HttpServletRequest request) {
		try {
			LoginUser user = new LoginUser();
			user = loginUserService.findReceptionUserByUsername(username);
			user.setUserId(user.getUserId().toString());
			session.setAttribute("SESSION_LOGIN_USER", user);
			model.addAttribute("user", user);
			String passwordtemp = MD5Util.convertMD5(password);
			if (passwordtemp.equals(user.getPassword())) {
				return 1;
			} else {
				return 0;// 密码或者用户名错误
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	

	@RequestMapping("/tologin.do")
	@ResponseBody
	public ModelAndView login(Model model) {
		ModelAndView modelAndView = new ModelAndView("/system/index");
		/*if (RedisClient.getIsConnection()) {
			System.out.println(getReport());
			modelAndView.addObject("messageList", getReport());
			modelAndView.addObject("ReportListLength",  getReport().size());
			modelAndView.addObject("messageList2", getMessage());
			modelAndView.addObject("messageSize",  getMessage().size());
		}*/
		return modelAndView;
	}

}
