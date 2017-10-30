package com.ebuy.service;

import com.ebuy.entity.EasybuyUser;

/**
 * 
 * @author linbingyang
 * @version 1.1 2017-10-30
 * 用户业务接口
 *
 */
public interface EasybuyUserService {
	/**
	 * 通过登陆名找用户
	 * @param loginName
	 * @return 找到返回true，否则返回false
	 */
	public boolean findUserByLoginName(String loginName);
	
	/**
	 * 用户注册
	 * @param user 用户实例
	 * @return	添加成功返回true，否则返回false
	 */
	public boolean registUser(EasybuyUser user);
}
