package com.ebuy.service;

import java.util.List;

import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;

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
	
	/**
	 * 用户登陆功能 
	 * @param loginName 用户登陆名
	 * @param password  用户密码
	 * @return          登陆成功后返回用户对象
	 */
	public EasybuyUser toLogin(String loginName,String password);
	
	/**
	 * 统计用户数量
	 * @return
	 */
	public int countUser();
	
	/**
	 * 获取用户分页
	 * @param currentNo
	 * @param pageSize
	 * @return
	 */
	public Page<EasybuyUser> findPageList(int currentNo,int pageSize);
}
