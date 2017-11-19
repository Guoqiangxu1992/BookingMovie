package com.ycx.manager.bean;


/**
* @author Create By Xuguoqiang
* @date   2017年11月15日--下午7:38:55--
*
*/
public class MovieIndex {
	private String ID;
	private String name;
	private Integer picturetotal;
	private String mainUrl;
	private String introduce;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPicturetotal() {
		return picturetotal;
	}
	public void setPicturetotal(Integer picturetotal) {
		this.picturetotal = picturetotal;
	}
	public String getMainUrl() {
		return mainUrl;
	}
	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


}
