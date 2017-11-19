package com.ycx.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycx.manager.ClassUtil.JsonUtils;
import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.service.OrderService;

import net.sf.json.JSONObject;

/**
* @author Create By Xuguoqiang
* @date   2017年10月29日--上午10:39:48--
*
*/

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	
	@RequestMapping(value="/orderList.do")
	public ModelAndView initOrderList(){
		return new ModelAndView("/system/order/orderList");
	}
	
	
	@RequestMapping(value = "/getOrderList.do")
	@ResponseBody
	public String getOrderList(OrderDto orderDto,HttpSession session) {
		orderDto.setLimit(orderDto.getPgLimit());
		orderDto.setPgNumber(orderDto.getPgCurrentPage());
		Pagination carpagination = orderService.getOrderList(orderDto);
		JSONObject jsonResult = JsonUtils.toGridJson(carpagination.getTotalCount(),carpagination.getResultList());
		return jsonResult.toString();
	}
	

}
