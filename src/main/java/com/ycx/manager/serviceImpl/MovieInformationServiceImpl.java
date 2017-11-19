package com.ycx.manager.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.nlpcn.commons.lang.util.CollectionUtil;
import org.springframework.stereotype.Service;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.bean.PictureInformation;
import com.ycx.manager.bean.ScheduleMovie;
import com.ycx.manager.dao.MovieInformationDao;
import com.ycx.manager.service.MovieInformationService;

/**
* @author Create By Yangchunxue
* @date   2017年10月21日--下午9:37:41--
*
*/
@Service
public class MovieInformationServiceImpl  implements MovieInformationService{
	@Resource
	private MovieInformationDao movieInformationDao;

	@Override
	public Pagination getMovieInformation(MovieInformationDto movieInfoDto) {
			List<MovieInformation> list = new ArrayList<MovieInformation>();
			int count = movieInformationDao.countGetMovieInformation(movieInfoDto);
			list = movieInformationDao.getMovieInformation(movieInfoDto);
			for(MovieInformation movieInformation:list){
				String movieId = movieInformation.getID();
				List<Date> dateList = movieInformationDao.getScheduleDate(movieId);
				if(CollectionUtils.isNotEmpty(dateList)){
					String dateStr = "";
					for(Date d:dateList){
						dateStr = dateStr+"@"+d;
					}
					movieInformation.setScheduleDate( dateStr );
				}
			}
			Pagination pageination = new Pagination();
			if(count<=0){
				return pageination;
			}
			pageination.setTotalCount(count);
			pageination.setResultList(list);
			return pageination;
	}

	@Override
	public void insertMovieInformation(MovieInformation movieInfo) {
		movieInformationDao.insertMovieInformation(movieInfo);
	}

	@Override
	public void savePictue(PictureInformation pictureInformation,int flag) {
		if(flag==0){
			movieInformationDao.deletePictue(pictureInformation);
		}
		movieInformationDao.savePictue(pictureInformation);
		
	}

	@Override
	public void publish(String movieId) {
		movieInformationDao.publish(movieId);
		
	}

	@Override
	public MovieInformation getMovieInfoById(String movieId) {
		return movieInformationDao.getMovieInfoById(movieId);
	}

	@Override
	public void updateMovieInfo(MovieInformation movieInfo) {
		movieInformationDao.updateMovieInfo(movieInfo);
		
	}

	@Override
	public void DateMovie(ScheduleMovie scheduleMovie) {
		movieInformationDao.DateMovie(scheduleMovie);
	}

	@Override
	public void undercarriage(String movieId) {
		movieInformationDao.undercarriage(movieId);
	}

}
