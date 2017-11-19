/**
 * 
 */
package com.ycx.manager.service;

import java.util.List;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.CarInformation;
import com.ycx.manager.bean.Pagination;

/**
* @author Create By Yangchunxue
* @date   2016年10月13日--下午11:40:29--
*
*/
/**
 * @author summer
 *
 */
public interface CarInformationService {

	/**
	 * @param carInfoDto
	 * @return
	 */
	public Pagination getCarInformation(MovieInformationDto carInfoDto);
	
	public void insertCarInformation(CarInformation carinformation );

}
