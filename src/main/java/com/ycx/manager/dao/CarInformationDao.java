/**
 * 
 */
package com.ycx.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.CarInformation;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.bean.PictureInformation;
import com.ycx.manager.bean.Price;

/**
* @author Create By Yangchunxue
* @date   2016年10月13日--下午11:45:47--
*
*/
/**
 * @author summer
 *
 */
public interface CarInformationDao {

	/**
	 * @param carInfoDto
	 * @return
	 */
	public List<CarInformation> getCarInformation(@Param("carInfoDto") MovieInformationDto carInfoDto);

	/**
	 * @param carInfoDto
	 * @return
	 */
	public int countGetCarInformation(MovieInformationDto carInfoDto);

	/**
	 * @param carinformation
	 */
	public void insertCarInformation(CarInformation carinformation);

	/**
	 * @param price
	 */
	public void insertCarPrice(Price price);

	/**
	 * @param picInfo
	 */
	public void savePictureInfo(PictureInformation picInfo);

	public List<String> queryBaseWord();
	
	public List<CarInformation> getCarInformation1(@Param("carInfoDto") MovieInformationDto carInfoDto);

	public void saveCarInformationBatch(List<CarInformation> carInfoList);

	public void deletedTempCarinfoemation(@Param("carIdList") List<Long> carIdList);

}
