package com.ycx.manager.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.nlpcn.commons.lang.util.CollectionUtil;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.ycx.manager.bean.MovieIndex;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Order;
import com.ycx.manager.bean.ScheduleMovie;
import com.ycx.manager.dao.IndexDao;
import com.ycx.manager.service.IndexService;

/**
* @author Create By Xuguoqiang
* @date   2017年11月15日--下午7:47:31--
*
*/
@Service
public class IndexServiceImpl implements IndexService{
	@Resource 
	private IndexDao indexDao;

	@Override
	public List<MovieIndex> getIndex() {
		List<MovieIndex> movielist = indexDao.getIndex();
		if(CollectionUtils.isEmpty(movielist)){
			return movielist;
		}
		for(MovieIndex movie :movielist){
			movie.setMainUrl(indexDao.getMainUrl(movie.getID()));
			movie.setPicturetotal(indexDao.countPicture(movie.getID()));
		}
		return movielist;
	}

	@Override
	public MovieInformation getMovieDetailIndex(Long movieId) {
		MovieInformation movieDetail = indexDao.getIndexDetail( movieId);
		movieDetail.setMainUrl(indexDao.getMainUrl(movieId.toString()));
		List<String > picList = indexDao.getUrlList(movieId);
		movieDetail.setUrlList(picList);
		return movieDetail;
	}

	@Override
	public List<ScheduleMovie> getscheduleMovieList(Long movieId) {
		return indexDao.getscheduleMovieList(movieId);
	}

	@Override
	public ScheduleMovie getscheduleMovie(Long id) {
		return indexDao.getscheduleMovie(id);
	}

	@Override
	public void saveOrder(Order order) {
		 indexDao.saveOrder(order);
	}

	@Override
	public List<Order> getCustomerOrder(String userId) {
		return indexDao.getCustomerOrder(userId);
	}

	@Override
	public void payment(Long id) {
		indexDao.payment(id);
		
	}



	@Override
	public void updateNum(Long id, Integer orderNum) {
		indexDao.updateNum(id,orderNum);
	}

}
