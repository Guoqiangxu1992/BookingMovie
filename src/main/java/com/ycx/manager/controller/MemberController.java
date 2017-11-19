package com.ycx.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
* @author Create By Xuguoqiang
* @date   2017年11月16日--下午12:21:12--
*
*/
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/login.do")
	public ModelAndView login(){
		return  new ModelAndView("/system/Reception/login");
		
	}
	
	@RequestMapping("/checkmember.do")
	public String checkmember(){
		
		
		return null;
		
	}
	

}
