package com.ycx.manager.Dto;

/**
* @author Create By Xuguoqiang
* @date   2017年10月29日--下午9:10:09--
*
*/
public class OrderDto extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customberName;
	private String movieName;
	private String status;
	public String getCustomberName() {
		return customberName;
	}
	public void setCustomberName(String customberName) {
		this.customberName = customberName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
