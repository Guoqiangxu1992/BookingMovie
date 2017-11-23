package com.ycx.manager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycx.manager.bean.LoginUser;
import com.ycx.manager.bean.MovieIndex;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.ScheduleMovie;
import com.ycx.manager.service.IndexService;
import com.ycx.manager.service.MovieInformationService;

/**
* @author Create By Xuguoqiang
* @date   2017年11月15日--下午6:11:56--
*
*/
@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private MovieInformationService movieInformationService;
	
	@RequestMapping(value = "/getMovieIndex.do")
	@ResponseBody
	public ModelAndView  getMovieIndex(Model model) {
		List<MovieIndex> list  = indexService.getIndex();
		model.addAttribute("list", list);
		return  new ModelAndView("/index");
	}
	
	
	@RequestMapping(value = "/getMovieDetailIndex.do")
	@ResponseBody
	public ModelAndView  getMovieDetailIndex(@RequestParam("movieId") Long movieId,Model model) {
		MovieInformation movieInfo  = indexService.getMovieDetailIndex(movieId);
		model.addAttribute("movieInfo", movieInfo);
		//影片热搜
		List<MovieIndex> newMovielist  = indexService.getIndex();
		
		model.addAttribute("newMovielist", newMovielist);
		//排期
		List<ScheduleMovie> scheduleMovieList  = indexService.getscheduleMovieList(movieId);
		model.addAttribute("scheduleMovieList", scheduleMovieList);
		return  new ModelAndView("/system/Reception/movieDetail");
		
	}
	
	
	
	@RequestMapping("/isLogin.do")
	@ResponseBody
	public int info( Model model,HttpSession session) {
		if(session.getAttribute("SESSION_LOGIN_USER")!=null){
			return 1;
		}
		return 0;
	}
	
	
	@RequestMapping(value = "/orderMovie.do")
	@ResponseBody
	public int  orderMovie(@RequestParam("movieId") Long movieId,@RequestParam("id") Long id,@RequestParam("orderNum") Integer orderNum,HttpSession session) {
		try{
			//获取电影信息
			MovieInformation movieInformation= movieInformationService.getMovieInfoById(movieId.toString());
			//获取排期信息
			ScheduleMovie scheduleMovie = indexService.getscheduleMovie(id);
			if(scheduleMovie.getNumber()<orderNum){
				return 2;//张数不足
			}
			//生成订单
			LoginUser loginUser = (LoginUser) session.getAttribute("SESSION_LOGIN_USER");
			Order order = new Order();
			order.setScheduleMovieId(String.valueOf(scheduleMovie.getId()));
			order.setCreateDate(new Date());
			order.setCustomerName(loginUser.getLoginName());
			order.setId(String.valueOf(System.currentTimeMillis()));
			order.setMemberId(loginUser.getUserId());
			order.setMovieId(movieId.toString());
			order.setMovieName(movieInformation.getName());
			order.setPlaceNum(scheduleMovie.getPlaceNum());
			order.setLanguag(scheduleMovie.getLanguag());
			order.setDate(scheduleMovie.getDate());
			order.setPayment(scheduleMovie.getMemberPrice());
			order.setOrderNumber(System.currentTimeMillis());
			order.setOrderNum(orderNum);
			indexService.saveOrder(order);
			indexService.updateNum(id,orderNum);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}

	
	@RequestMapping(value = "/getCustomerOrder.do")
	@ResponseBody
	public ModelAndView  getCustomerOrder(Model model,HttpSession session) {
		try{
			LoginUser loginUser = (LoginUser) session.getAttribute("SESSION_LOGIN_USER");
			List<Order> orderList = new ArrayList<Order>();
			orderList = indexService.getCustomerOrder(loginUser.getUserId());
			model.addAttribute("orderList", orderList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("/system/Reception/customerOrder");
	}
	
	
	@RequestMapping(value = "/payment.do")
	@ResponseBody
	public int  payment(@RequestParam("id") Long id) {
		try{
			indexService.payment(id);
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	
	
	
	

}
