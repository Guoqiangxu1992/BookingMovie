package com.ycx.manager.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.PictureInformation;
import com.ycx.manager.bean.ScheduleMovie;

/**
* @author Create By Yangchunxue
* @date   2017年10月21日--下午9:46:58--
*
*/
public interface MovieInformationDao {

	int countGetMovieInformation(@Param("movieInfoDto")MovieInformationDto movieInfoDto);

	List<MovieInformation> getMovieInformation(@Param("movieInfoDto")MovieInformationDto movieInfoDto);

	public void insertMovieInformation(@Param("movieInfo")MovieInformation movieInfo);

	void savePictue(@Param("pictureInformation")PictureInformation pictureInformation);

	void publish(@Param("movieId")String movieId);

	MovieInformation getMovieInfoById(@Param("movieId")String movieId);

	void updateMovieInfo(@Param("movieInfo")MovieInformation movieInfo);

	void deletePictue(@Param("pictureInformation")PictureInformation pictureInformation);

	void DateMovie(@Param("scheduleMovie")ScheduleMovie scheduleMovie);

	List<Date> getScheduleDate(@Param("movieId")String movieId);

	void undercarriage(@Param("movieId")String movieId);

}
