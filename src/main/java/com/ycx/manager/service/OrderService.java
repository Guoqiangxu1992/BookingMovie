package com.ycx.manager.service;

import com.ycx.manager.Dto.OrderDto;
import com.ycx.manager.bean.Pagination;

/**
* @author Create By Xuguoqiang
* @date   2017年10月29日--下午9:12:45--
*
*/
public interface OrderService {

	Pagination getOrderList(OrderDto orderDto);

}
