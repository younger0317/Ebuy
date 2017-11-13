package com.ebuy.service.impl;

import java.util.List;

import com.ebuy.dao.EasybuyOrderDetailDao;
import com.ebuy.dao.impl.EasybuyOrderDetailDaoImpl;
import com.ebuy.entity.EasybuyOrderDetail;
import com.ebuy.service.EasybuyOrderDetailService;
import com.ebuy.util.DatabaseUtil;
import com.ebuy.util.MybatisUtil;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;


public class EasybuyOrderDetailServiceImpl {
	
	/**
	 * 通过orderId查询所有订单详情信息
	 * @param orderId
	 * @return
	 */
	/*@Override*/
/*	public List<EasybuyOrderDetail>findEasybuyOrderDetailList(Integer orderId) {
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		List<EasybuyOrderDetail> easybuyOrderDetailList = sqlSession.getMapper(OrderDetailDao.class).getEasybuyOrderDetailList(orderId);
		MybatisUtil.Close(sqlSession);
		return easybuyOrderDetailList;*/
	/*@Override
	public List<EasybuyOrderDetail>findEasybuyOrderDetailList(Integer orderId) {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		*//**
		 * 调用分类dao属性
		 *//*
		EasybuyOrderDetailDao easybuyOrderDetailDao=new EasybuyOrderDetailDaoImpl(conn);
		// TODO Auto-generated method stub
		List<EasybuyOrderDetail> easybuyOrderDetailList = easybuyOrderDetailDao.getEasybuyOrderDetailList(orderId);
		DatabaseUtil.closeAll(conn, null, null);
		return easybuyOrderDetailList;
	}*/
	
	/*}*/
}
