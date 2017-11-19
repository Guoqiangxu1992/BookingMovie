package com.ycx.manager.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.ycx.manager.framework.XgqSessionBag;

/**
* @author Create By Yangchunxue
* @date   2016年12月6日--下午9:50:13--
*
*/
public class App1RequestListener implements ServletRequestListener{
	

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
			XgqSessionBag.clear();
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
	}
}
