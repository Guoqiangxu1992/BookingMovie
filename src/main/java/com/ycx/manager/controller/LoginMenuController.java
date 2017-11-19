/**
 * 
 */
package com.ycx.manager.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.MenuBean;
import com.ycx.manager.framework.XgqSessionBag;
import com.ycx.manager.service.MenuService;

/**
* @author Create By Yangchunxue
* @date   2016年7月29日--下午2:36:33--
*
*/
@Controller
@Scope("prototype")
@RequestMapping("/menu")
public class LoginMenuController {
	
	@Autowired
	private MenuService menuService;
	/*根据用户名获取菜单*/
	@RequestMapping(value = "/getMenuByName.do")
	@ResponseBody
	public String getMenuByName(LoginUser user,HttpSession session,Model model){
		LoginUser loginUser = (LoginUser) session.getAttribute("SESSION_LOGIN_USER");
		List<Map<String, MenuBean>> lst = menuService.getMenuByName(loginUser.getLoginName());
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		return  json;
		
	}

}
