package com.ycx.manager.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ycx.manager.ClassUtil.DateUtil;
import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.dao.IndexDao;
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
	@Resource 
	private IndexDao indexDao;

	@Override
	public Pagination getOrderList(OrderDto orderDto) {
		List<Order> list = new ArrayList<Order>();
		int count = orderDao.countOrderList(orderDto);
		list = orderDao.getOrderList(orderDto);
		
		Pagination pageination = new Pagination();
		if(count<=0){
			return pageination;
		}else{
			for(Order order :list){
				 SimpleDateFormat sdf =   new SimpleDateFormat( "  yyyy-MM-dd " );
				order.setTimeStr(sdf.format(order.getCreateDate()));
			}
		}
		pageination.setTotalCount(count);
		pageination.setResultList(list);
		return pageination;
	}

	@Override
	public void cancelOrder(String id, int orderNum,String scheduleMovieId) {
		orderDao.cancelOrder(id,orderNum);
		indexDao.updateCancelNum(scheduleMovieId,orderNum);
	}

}
