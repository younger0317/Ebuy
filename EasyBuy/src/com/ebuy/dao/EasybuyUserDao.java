package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyUser;

/**
 * 
 * @author linbingyang
 * @version 1.1 2017-10-30
 * 用户Dao接口
 *
 */
public interface EasybuyUserDao {
	/**
	 * 用户查找方法
	 * @param appendSql 添加查找条件
	 * @param params	参数列表
	 * @return			结果集对象集合
	 */
	public List<EasybuyUser> getEasybuyUserList(String appendSql,Object...params);
	
	/**
	 * 添加用户
	 * @param user 用户对象
	 * @return 更新行数
	 */
	public int addEasybuyUser(EasybuyUser user);
	
	/**
	 * 统计记录总数
	 * @return 统计的条数
	 */
	public int countUser();
	
	/**
	 * 更新用户信息
	 * @param appendSql sql拼接语句
	 * @param params	参数列表
	 * @return			更新行数
	 */
	public int upDateUserInfo(String appendSql,Object...params);
	
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return	更新行数
	 */
	public int delUserById(int id);
	
}
