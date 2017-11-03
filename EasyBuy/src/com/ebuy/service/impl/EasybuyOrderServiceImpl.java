package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import com.ebuy.dao.EasybuyOrderDao;
import com.ebuy.dao.impl.EasybuyOrderDaoImpl;
import com.ebuy.entity.EasybuyOrder;
import com.ebuy.service.EasybuyOrderService;
import com.ebuy.util.DatabaseUtil;

public class EasybuyOrderServiceImpl implements EasybuyOrderService {
	@Override
	public List<EasybuyOrder> findEasybuyOrdersList() {
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		/**
		 * 调用分类dao属性
		 */
		EasybuyOrderDao easybuyOrderDao=new EasybuyOrderDaoImpl(conn);
		// TODO Auto-generated method stub
		List<EasybuyOrder> easybuyOrdersList = easybuyOrderDao.getEasybuyOrdersList();
		DatabaseUtil.closeAll(conn, null, null);
		return easybuyOrdersList;
		
	}
	

}
