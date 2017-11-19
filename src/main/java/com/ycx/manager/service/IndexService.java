package com.ycx.manager.service;

import java.util.List;

import com.ycx.manager.bean.MovieIndex;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.ScheduleMovie;

/**
* @author Create By Xuguoqiang
* @date   2017年11月15日--下午7:45:51--
*
*/
public interface IndexService {

	List<MovieIndex> getIndex();

	MovieInformation getMovieDetailIndex(Long movieId);

	List<ScheduleMovie> getscheduleMovieList(Long movieId);

	ScheduleMovie getscheduleMovie(Long id);

	void saveOrder(Order order);

	List<Order> getCustomerOrder(String userId);

	void payment(Long id);


	void updateNum(Long id, Integer orderNum);

}
