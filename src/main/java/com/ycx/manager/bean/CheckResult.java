package com.ycx.manager.bean;

/**
* @author Create By Yangchunxue
* @date   2017年3月18日--下午10:23:07--
*
*/
public class CheckResult {
	private Long id;
	private Long carId;
	private String carName;
	private String result;
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long long1) {
		this.carId = long1;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
