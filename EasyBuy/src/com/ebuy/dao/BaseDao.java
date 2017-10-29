package com.ebuy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-29
 * 基础Dao
 * @param <T>
 */
public abstract class BaseDao<T> {
	private Logger log = Logger.getLogger(BaseDao.class);
	
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/ebuy","root","root");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public int executeUpdate(String sql,Object...parms){
		Connection conn = null;
		PreparedStatement ps = null;
		int updata = -1;
		try {
			conn = getConnection();
			log.debug("建立链接");
			ps = conn.prepareStatement(sql);
			if(parms != null){
				for (int i = 0; i < parms.length; i++) {
					ps.setObject(i+1, parms[i]);
				}				
			}
			log.debug("执行SQL语句");
			updata = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, ps, null);
		}
		return updata;
	}
	
	public List<T> executeQuery(String sql,Object...parms){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		
		try {
			conn = getConnection();
			log.debug("建立链接");
			ps= conn.prepareStatement(sql);
			if(parms != null){
				for (int i = 0; i < parms.length; i++) {
					ps.setObject(i+1, parms[i]);
				}				
			}
			log.debug("执行SQL语句");
			rs = ps.executeQuery();
			while(rs.next()){
				T t = getEntity(rs);
				list.add(t);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(conn, ps, rs);
		}
		return null;
	}
	
	public abstract T getEntity(ResultSet rs);
	
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int recordCarPurchaseTax() {
		// TODO Auto-generated method stub
		return 0;
	}
}
