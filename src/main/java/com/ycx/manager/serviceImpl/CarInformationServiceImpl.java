/**
 * 
 */
package com.ycx.manager.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.CarInformation;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.bean.Price;
import com.ycx.manager.bean.RegisterUser;
import com.ycx.manager.dao.CarInformationDao;
import com.ycx.manager.service.CarInformationService;

/**
* @author Create By Yangchunxue
* @date   2016年10月13日--下午11:42:46--
*
*/
/**
 * @author summer
 *
 */
@Service("carInformationService")
@Scope("prototype")
@Transactional
public class CarInformationServiceImpl implements CarInformationService{
	
	@Autowired
	private CarInformationDao carInformationDao;

	@Override
	public Pagination getCarInformation(MovieInformationDto carInfoDto) {
		Long a = System.currentTimeMillis();
		Pagination pageination = new Pagination();
		List<CarInformation> list = new ArrayList<CarInformation>();
		int count = carInformationDao.countGetCarInformation(carInfoDto);
		list = carInformationDao.getCarInformation(carInfoDto);
		Long b = System.currentTimeMillis();
		System.out.println("耗时："+(b-a));
		if(CollectionUtils.isNotEmpty(list)){
			pageination.setResultList(list);
			pageination.setTotalCount(count);
		}
		return pageination;
	}

	/* (non-Javadoc)
	 * 保存车辆信息
	 */
	@Override
	public void insertCarInformation(CarInformation carinformation) {
           		Price price = new Price();
           		price.setCarId(carinformation.getCarId());
           		if(carinformation.getPrice()!=null){
           			price.setCarPrice(carinformation.getPrice().getCarPrice());
           		}
           		RegisterUser register = new RegisterUser();
           		carInformationDao.insertCarInformation(carinformation);
           		carInformationDao.insertCarPrice(price);
	}


}
