/**
 * 
 */
package com.ycx.manager.dao;

import java.util.List;
import java.util.Map;

import com.ycx.manager.bean.MenuBean;

/**
* @author Create By Yangchunxue
* @date   2016年7月30日--下午1:24:24--
*
*/

public interface MenuDao {

	/**
	 * @param name
	 * @return
	 */
	public List<Map<String, MenuBean>> getMenuByName(String name);

}
