package com.ebuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ebuy.util.DatabaseUtil;
/**
 * 
 * @author linbingyang
 * @version 1.1   2017-10-30
 * 基础Dao，进行相应的数据库操作
 * @param <T> 对应的操作实体
 */

public abstract class BaseDao<T> {
	
	private Logger log = Logger.getLogger(BaseDao.class);
	
	/**
	 * 保存BaseDao的链接对象
	 */
	private Connection conn;
	
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * BaseDao的有参构造方法，用于接受connection
	 * @param conn
	 */
	public BaseDao(Connection conn) {
	super();
	log.debug(">>>>>>>>获得链接");
	this.conn = conn;
	}

	/**
	 * 数据增、删、改操作
	 * @param sql
	 * @param parms
	 * @return
	 */
	public int executeUpdate(String sql,Object...parms){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < parms.length; i++) {
				ps.setObject(i+1, parms[i]);
			}
			log.debug(">>>>>>进行增删改操作");
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, null);
		}
		return -1;
	}
	
	/**
	 * 数据库查询操作
	 * @param sql
	 * @param parms
	 * @return 结果集
	 */
	public List<T> executeQuery(String sql,Object...parms){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		
		try {
			ps= conn.prepareStatement(sql);
			if(parms != null){
				for (int i = 0; i < parms.length; i++) {
					ps.setObject(i+1, parms[i]);
				}				
			}
			log.debug(">>>>>>进行查找操作");
			rs = ps.executeQuery();
			while(rs.next()){
				T t = getEntity(rs);
				list.add(t);
			}
			log.debug(">>>>>>成功"+sql);
			return list;
		} catch (SQLException e) {
			log.error(e);
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, rs);
		}
		return null;
	}
	
	/**
	 * 查询统计结果
	 * @param sql 查询语句
	 * @param parms 参数
	 * @return	统计结果
	 */
	public int executeQueryCount(String sql,Object...parms){
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			if(parms != null){
				for (int i = 0; i < parms.length; i++) {
					ps.setObject(i+1, parms[i]);
				}				
			}
			log.debug(">>>>>>成功"+sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DatabaseUtil.closeAll(null, ps, rs);
		}
		return count;
		
	}
	
	/**
	 * 获取相应的实体对象
	 * @param rs
	 * @return
	 */
	public abstract T getEntity(ResultSet rs);
	
	/**
	 * @author anwensheng
	 * @version 1.0 2017.11.01
	 * 查询数据库返回值类型为ResltSet方法
	 * 
	 */
	public ResultSet resultQuery(String sql,Object...params){
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			 
			ps = conn.prepareStatement(sql);
			
			if (params!=null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return rs;
	}
	
	
}
