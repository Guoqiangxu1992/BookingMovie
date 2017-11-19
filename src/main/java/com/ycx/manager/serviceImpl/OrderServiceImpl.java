package com.ycx.manager.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.dao.OrderDao;
import com.ycx.manager.service.OrderService;

/**
* @author Create By Xuguoqiang
* @date   2017年10月29日--下午9:13:22--
*
*/
@Service
public class OrderServiceImpl  implements OrderService{
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Pagination getOrderList(OrderDto orderDto) {
		List<Order> list = new ArrayList<Order>();
		int count = orderDao.countOrderList(orderDto);
		list = orderDao.getOrderList(orderDto);
		Pagination pageination = new Pagination();
		if(count<=0){
			return pageination;
		}
		pageination.setTotalCount(count);
		pageination.setResultList(list);
		return pageination;
	}

}
