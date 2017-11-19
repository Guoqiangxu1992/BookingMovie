package com.ycx.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Order;

/**
* @author Create By Xuguoqiang
* @date   2017年10月29日--下午9:15:22--
*
*/
public interface OrderDao {

	int countOrderList(@Param("orderDto")OrderDto orderDto);

	List<Order> getOrderList(@Param("orderDto")OrderDto orderDto);

}
