package com.ebuy.dao.newdao;

import java.util.List;

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
	
	/**
	 * 通过用户id找到用户
	 * @param id 用户id
	 * @return   用户对象
	 */
	public EasybuyUser findUserById(@Param("id")Integer id);
	
	/**
	 * 更新用户信息
	 * @param user 更新的用户对象
	 * @return	   影响行数
	 */
	public int updateUser(EasybuyUser user);
	
	/**
	 * 用过用户id，删除用户
	 * @param id 用户id
	 * @return	 影响行数
	 */
	public int delUserById(@Param("id")Integer id);
	
	/**
	 * 分页显示
	 * @param currentNo
	 * @param pageSize
	 * @return
	 */
	public List<EasybuyUser> findUserPageList(@Param("currentNo")Integer currentNo,@Param("pageSize")Integer pageSize);
	
}
