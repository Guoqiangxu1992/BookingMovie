package com.ycx.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycx.manager.bean.MovieIndex;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.ScheduleMovie;

/**
* @author Create By Xuguoqiang
* @date   2017年11月15日--下午7:48:34--
*
*/
public interface IndexDao {

	List<MovieIndex> getIndex();

	String getMainUrl(@Param("ID")String id);

	Integer countPicture(@Param("ID")String id);

	MovieInformation getIndexDetail(@Param("movieId")Long movieId);

	List<String> getUrlList(@Param("movieId")Long movieId);

	List<ScheduleMovie> getscheduleMovieList(@Param("movieId")Long movieId);

	ScheduleMovie getscheduleMovie(@Param("id")Long id);

	void saveOrder(@Param("order")Order order);

	List<Order> getCustomerOrder(@Param("userId")String userId);

	void payment(@Param("id")Long id);

	void updateNum(@Param("id")Long id,@Param("orderNum") Integer orderNum);

	void updateCancelNum(@Param("id")String id,@Param("orderNum") int orderNum);

}
