package com.ycx.manager.bean;

import java.util.Date;

/**
* @author Create By Xuguoqiang
* @date   2017年10月29日--下午9:00:29--
*
*/
public class Order {
	
	private String id;
	private String memberId;
	private String customerName;
	private String phone;
	private String email;
	private Double payment;
	private String remark;
	private Date createDate;
	private Integer status;
	private Integer originalPrice;
	private String movieId;
	private String movieName;
	private Double price;
	private Long orderNumber;
	private String placeNum;
	private String languag;
	private Date date;
	private Double  marketPrice;
	private Double memberPrice;
	private int orderNum;
	private String timeStr;
	private String scheduleMovieId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getPlaceNum() {
		return placeNum;
	}
	public void setPlaceNum(String placeNum) {
		this.placeNum = placeNum;
	}
	public String getLanguag() {
		return languag;
	}
	public void setLanguag(String languag) {
		this.languag = languag;
	}
	public String getScheduleMovieId() {
		return scheduleMovieId;
	}
	public void setScheduleMovieId(String scheduleMovieId) {
		this.scheduleMovieId = scheduleMovieId;
	}
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public Date getDate() {
		return date;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	

}
