/**
 * 
 */
package com.ycx.manager.Dto;

import java.sql.Date;

/**
 * @author Create By Yangchunxue
 * @date 2016年10月13日--下午11:33:14--
 *
 */
public class MovieInformationDto extends BaseDto {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Integer ID;
	private String Name;
	private String productType;
	private Integer status;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
