package com.ycx.manager.serviceImpl;

import com.ycx.manager.Dto.MovieInformationDto;
import com.ycx.manager.bean.CarInformation;
import com.ycx.manager.bean.Pagination;
import com.ycx.manager.service.CarInformationService;

/**
* @author Create By Yangchunxue
* @date   2017年4月10日--下午9:25:00--
*
*/
public class CarInformationServiceProxyImpl implements CarInformationService{
	private CarInformationService carInformationService;
	
	public CarInformationServiceProxyImpl(CarInformationService carInformationService){
		this.carInformationService = carInformationService;
	}

	@Override
	public Pagination getCarInformation(MovieInformationDto carInfoDto) {
		System.out.println("**********getCarInformation method start ！！！");
		carInformationService.getCarInformation(carInfoDto);
		System.out.println("**********getCarInformation method end ！！！");
		return null;
	}

	@Override
	public void insertCarInformation(CarInformation carinformation) {
		carInformationService.insertCarInformation(carinformation);
	}

}
