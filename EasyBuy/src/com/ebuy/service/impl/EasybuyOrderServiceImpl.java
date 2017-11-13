package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ebuy.dao.EasybuyOrderDao;
import com.ebuy.dao.impl.EasybuyOrderDaoImpl;
import com.ebuy.dao.newdao.OrderDao;
import com.ebuy.entity.EasybuyOrder;
import com.ebuy.service.EasybuyOrderService;
import com.ebuy.util.DatabaseUtil;
import com.ebuy.util.MybatisUtil;

public class EasybuyOrderServiceImpl implements EasybuyOrderService {
	
	public List<EasybuyOrder> findEasybuyOrdersList() {
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		List<EasybuyOrder> easybuyOrdersList = sqlSession.getMapper(OrderDao.class).getEasybuyOrdersList();
		MybatisUtil.Close(sqlSession);
		return easybuyOrdersList;
	}
	
	
	/*@Override
	public List<EasybuyOrder> findEasybuyOrdersList() {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		*//**
		 * 调用分类dao属性
		 *//*
		EasybuyOrderDao easybuyOrderDao=new EasybuyOrderDaoImpl(conn);
		// TODO Auto-generated method stub
		List<EasybuyOrder> easybuyOrdersList = easybuyOrderDao.getEasybuyOrdersList();
		DatabaseUtil.closeAll(conn, null, null);
		return easybuyOrdersList;
		
	}*/
	

}
