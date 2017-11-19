package com.ycx.manager.service;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.MovieInformation;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.bean.PictureInformation;
import com.ycx.manager.bean.ScheduleMovie;

/**
* @author Create By Yang
* @date   2017年10月21日--下午9:37:41--
*
*/
public interface MovieInformationService {

	public Pagination getMovieInformation(MovieInformationDto movieInfoDto);

	public void insertMovieInformation(MovieInformation movieInfo);

	public void savePictue(PictureInformation pictureInformation, int i);

	public void publish(String movieId);

	public MovieInformation getMovieInfoById(String movieId);

	public void updateMovieInfo(MovieInformation movieInfo);

	public void DateMovie(ScheduleMovie scheduleMovie);

	public void undercarriage(String movieId);

}
