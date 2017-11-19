package com.ycx.manager.bean;

import java.util.Date;

/**
* @author Create By Xuguoqiang
* @date   2017年11月17日--下午3:41:51--
*
*/
public class ScheduleMovie {
	private Long id;
	private Long movieId;
	private String placeNum;
	private String languag;
	private String date1;
	private Date date;
	private Double  marketPrice;
	private Double memberPrice;
	private Integer number;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getPlaceNum() {
		return placeNum;
	}
	public void setPlaceNum(String placeNum) {
		this.placeNum = placeNum;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Double getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(Double memberPrice) {
		this.memberPrice = memberPrice;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getLanguag() {
		return languag;
	}
	public void setLanguag(String languag) {
		this.languag = languag;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	
	

}
