package com.ebuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.EasybuyUserDao;
import com.ebuy.dao.impl.EasybuyUserDaoImpl;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.service.EasybuyUserService;
import com.ebuy.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 用户业务实现类
 *
 */
public class EasybuyUserServiceImpl implements EasybuyUserService {
	
	/**
	 * 通过用户名找用户
	 */
	@Override
	public boolean findUserByLoginName(String loginName) {
		boolean flag = false;
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		try {
			//关闭自动提交，开启事务
			conn.setAutoCommit(false);
			//创建Dao对象
			EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
			//业务过程
			String appendSql = "WHERE loginName=?";
			List<EasybuyUser> userList = userDao.getEasybuyUserList(appendSql, loginName);
			
			if(userList != null && userList.size()>0){
				flag = true;
			}
			//提交事务
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if(conn != null){
				try {
					flag = true;
					//事务回滚
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally{
			//关闭资源
			DatabaseUtil.closeAll(conn, null, null);
		}
		return flag;
	}
	
	/**
	 * 用户注册
	 */
	@Override
	public boolean registUser(EasybuyUser user) {
		boolean flag = false;
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		//业务过程
		int update = userDao.addEasybuyUser(user);
		if(update!=-1 && update>0){
			flag = true;
		}
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return flag;
	}
	
	/**
	 * 用户登陆
	 */
	@Override
	public EasybuyUser toLogin(String loginName, String password) {
		EasybuyUser user = null;
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		//业务流程
		String sql = "where loginName=? and password=?";
		List<EasybuyUser> userList = userDao.getEasybuyUserList(sql, loginName,password);
		if(userList!=null && userList.size()>0){
			user = userList.get(0);
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return user;
	}
}
