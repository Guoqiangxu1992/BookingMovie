package com.ycx.manager.bean;

/**
* @author Create By Xuguoqiang
* @date   2017年11月23日--下午12:12:09--
*
*/
public class OrderData {
	private String dateStr;
	private Integer number;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(Integer movieNum) {
		this.movieNum = movieNum;
	}
	private String movieName;
	private Integer movieNum;
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

}
