package com.ycx.manager.bean;

import java.util.Date;
import java.util.List;

/**
 * @author Create By Yangchunxue
 * @date 2017年10月21日--下午9:48:30--
 *
 */
public class MovieInformation {

	private String ID;
	private String productType;
	private String name;
	private String introduce;
	private String remark;
	private Double marketPrice;
	private Double membersPrice;
	private Integer recommed;
	private Date recommendDate;
	private Integer status;
	private String operator;
	private String director;
	private String tostar;
	private String mainUrl;
	private List<String > urlList;
	private String scheduleDate;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Double getMembersPrice() {
		return membersPrice;
	}

	public void setMembersPrice(Double membersPrice) {
		this.membersPrice = membersPrice;
	}

	public Integer getRecommed() {
		return recommed;
	}

	public void setRecommed(Integer recommed) {
		this.recommed = recommed;
	}

	public Date getRecommendDate() {
		return recommendDate;
	}

	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}



	public String getMainUrl() {
		return mainUrl;
	}

	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}



	public String getTostar() {
		return tostar;
	}

	public void setTostar(String tostar) {
		this.tostar = tostar;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

}
