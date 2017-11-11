package com.ebuy.dao.newdao;

import org.apache.ibatis.annotations.Param;

import com.ebuy.entity.EasybuyUser;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-11-11
 * 用户dao（mybatis）
 *
 */
public interface UserDao {
	
	/**
	 * 统计用户表总条目
	 * @return
	 */
	public int countUser();
	
	/**
	 * 通过用户登陆名，用户密码，找用户
	 * @param loginName	用户登陆名
	 * @param password	 用户密码
	 * @return			用户对象
	 */
	public EasybuyUser findUserByName(@Param("loginName")String loginName,@Param("password")String password);
	
	/**
	 * 添加新用户
	 * @param user
	 * @return
	 */
	public int addUser(EasybuyUser user);
	
}
