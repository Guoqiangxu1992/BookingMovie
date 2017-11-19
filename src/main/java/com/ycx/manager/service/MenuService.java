/**
 * 
 */
package com.ycx.manager.service;

import java.util.List;
import java.util.Map;

import com.ycx.manager.bean.MenuBean;

/**
* @author Create By Yangchunxue
* @date   2016年7月30日--下午1:14:54--
*
*/
/**
 * @author summer
 *
 */
public interface MenuService {

	/**
	 * @return
	 */
	public List<Map<String, MenuBean>> getMenuByName(String name);

}
