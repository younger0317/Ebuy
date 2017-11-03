package com.ebuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.EasybuyUserDao;
import com.ebuy.dao.impl.EasybuyUserDaoImpl;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyUserService;
import com.ebuy.servlet.UserServlet;
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
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		try {
			//关闭自动提交，开启事务
			conn.setAutoCommit(false);
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
	
	/**
	 * 统计用户数量
	 */
	@Override
	public int countUser() {
		EasybuyUser user = null;
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		//业务流程
		int totalCount=0;
		totalCount = userDao.countUser();
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return totalCount;
	}
	
	/**
	 * 获取当前页内容
	 */
	@Override
	public Page<EasybuyUser> findPageList(int currentNo, int pageSize) {
		Page<EasybuyUser> page = new Page<EasybuyUser>();
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		//业务流程
		String sql = "limit ?,? ";
		//获取集合
		List<EasybuyUser> pageList = userDao.getEasybuyUserList(sql, (currentNo-1)*pageSize,pageSize);
		//获取总条数
		int totalCount = userDao.countUser();
		//设置page参数
		page.setCurrentNo(currentNo);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setTotalPageCount(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1 );
		page.setPageList(pageList);
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return page;
	}
	
	/**
	 * 通过id找对象
	 */
	@Override
	public EasybuyUser findUserById(int id) {
		EasybuyUser user = null;
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		//业务逻辑
		String sql = "where id = ?";
		List<EasybuyUser> list = userDao.getEasybuyUserList(sql, id);
		if(list != null && list.size()>0){
			user = list.get(0);
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return user;
	}
	
	/**
	 * 更改用户对象
	 */
	@Override
	public boolean modifyUser(EasybuyUser user) {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		boolean flag = false;
		//业务逻辑
		String sql = "loginName=?,userName=?,identityCode=?,email=?,mobile=?,type=? where id=?";
		int update = userDao.upDateUserInfo(sql, user.getLoginName(),user.getUserName(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType(),user.getId());
		
		if(update>0){
			flag = true;
		}else{
			flag = false;
		}
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return flag;
	}
	
	/**
	 * 删除操作
	 */
	@Override
	public boolean delUserById(int id) {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyUserDao userDao = new EasybuyUserDaoImpl(conn);
		boolean flag = false;
		//业务逻辑
		int del = userDao.delUserById(id);
		if(del>0){
			flag = true;
		}
		
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return flag;
	}
}
