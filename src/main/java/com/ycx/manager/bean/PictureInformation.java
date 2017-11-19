/**
 * 
 */
package com.ycx.manager.bean;

import java.io.Serializable;
import java.util.Date;

/**
* @author Create By Yangchunxue
* @date   2016年10月24日--下午10:42:15--
*
*/
public class PictureInformation{
	private Long id;
	private Long movieId;
	private Long pictureId;
	private String url;
	private Long size;
	private String originalName;
	private Date createTime;
	private Long uploaderId;
	private String ip;
	private Integer main;
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
	public Long getPictureId() {
		return pictureId;
	}
	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getUploaderId() {
		return uploaderId;
	}
	public void setUploaderId(Long uploaderId) {
		this.uploaderId = uploaderId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getMain() {
		return main;
	}
	public void setMain(Integer main) {
		this.main = main;
	}
	
}
