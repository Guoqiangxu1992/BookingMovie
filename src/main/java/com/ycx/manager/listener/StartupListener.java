package com.ycx.manager.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;


/**
* @author Create By Yangchunxue
* @date   2017年5月7日--下午9:47:14--
*初始化监听redis发过来的消息，在app启动后一直监听
*/
@Service
public class StartupListener implements ApplicationListener<ContextRefreshedEvent >{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
	}

}
