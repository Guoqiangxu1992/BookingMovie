package com.ycx.quartz;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ycx.manager.ClassUtil.SpringUtils;
import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.service.OrderService;

/**
* @author Create By Xuguoqiang
* @date   2017年11月23日--下午6:27:00--
*
*/
@Service
public class CancelOrderQuartz implements Job{
	
	


	private static Log logger = LogFactory.getLog(CancelOrderQuartz.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try{
	        System.out.println("*******************************开始处理超时未支付的订单*************************");
	        Long st = System.currentTimeMillis();
	        OrderDto orderDto = new OrderDto();
	        orderDto.setStatus("0");
	        orderDto.setLimit(10000);
	        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:spring/spring-applicationContext.xml");
	        OrderService orderService = (OrderService) appContext.getBean("orderService");
	        Pagination carpagination = orderService.getOrderList(orderDto);
	        @SuppressWarnings("unchecked")
			List<Order> orderList = carpagination.getResultList();
	        for(Order o :orderList){
	        	Long now = System.currentTimeMillis();
	        	Long create = o.getCreateDate().getTime();
	        	if((now-create)>30*60*1000){
	        		orderService.cancelOrder(o.getId(),o.getOrderNum(),o.getScheduleMovieId());
	        		System.out.println("orderId:"+o.getId()+"    movieName:"+o.getMovieName()+"失效张数："+o.getOrderNum());
	        	}
	        }
	        Long end = System.currentTimeMillis();
	        System.out.println("*******************************结束处理超时未支付的订单*************************");
	        System.out.println("耗时(秒)："+(end-st)/1000);
		}catch(Exception e){
			logger.error("处理超时未支付的订单 error!!", e);
		}
	}

}
