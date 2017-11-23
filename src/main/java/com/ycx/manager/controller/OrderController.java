package com.ycx.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ycx.manager.ClassUtil.JsonUtils;
import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.OrderData;
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
		System.out.println(jsonResult.toString());
		return jsonResult.toString();
	}
	
	
	@RequestMapping(value="/oderListPlan.do")
	public ModelAndView oderListPlan(){
		
		return new ModelAndView("/system/order/oderListPlan");
	}
	
	
	@RequestMapping(value = "/getOrderPlanList.do")
	@ResponseBody
	public String getOrderPlanList(OrderDto orderDto,HttpSession session) {
		orderDto.setLimit(5000);
		orderDto.setStatus("1");
		Pagination carpagination = orderService.getOrderList(orderDto);
		List<Order> orderList  =  carpagination.getResultList();
		Map<String, Integer> map = new HashMap<>();
		for(Order order: orderList){
			if(map.get(order.getTimeStr())!=null){
				map.put(order.getTimeStr(), map.get(order.getTimeStr())+order.getOrderNum());
			}else{
				map.put(order.getTimeStr(), order.getOrderNum());
			}
		}
		List<OrderData> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {  
			  
			  OrderData orderData = new OrderData();
			  orderData.setDateStr(entry.getKey().trim());
			  orderData.setNumber(entry.getValue());
			  list.add(orderData);
		      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		  
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	
	
	
	@RequestMapping(value = "/getOrderPlanList1.do")
	@ResponseBody
	public String getOrderPlanList1(OrderDto orderDto,HttpSession session) {
		orderDto.setLimit(5000);
		orderDto.setStatus("1");
		Pagination carpagination = orderService.getOrderList(orderDto);
		List<Order> orderList  =  carpagination.getResultList();
		Map<String, Integer> map = new HashMap<>();
		for(Order order: orderList){
			if(map.get(order.getMovieName())!=null){
				map.put(order.getMovieName(), map.get(order.getMovieName())+order.getOrderNum());
			}else{
				map.put(order.getMovieName(), order.getOrderNum());
			}
		}
		List<OrderData> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {  
			  
			  OrderData orderData = new OrderData();
			  orderData.setMovieName(entry.getKey().trim());
			  orderData.setMovieNum(entry.getValue());
			  list.add(orderData);
		      System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
		  
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	

}
