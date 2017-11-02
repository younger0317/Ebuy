package com.ebuy.service.impl;

import java.util.List;

import com.ebuy.dao.EasybuyOrderDetailDao;
import com.ebuy.dao.impl.EasybuyOrderDetailDaoImpl;
import com.ebuy.entity.EasybuyOrderDetail;
import com.ebuy.service.EasybuyOrderDetailService;
import com.ebuy.util.DatabaseUtil;
import java.sql.Connection;


public class EasybuyOrderDetailServiceImpl implements EasybuyOrderDetailService {
	
	//获取数据库链接
	Connection conn = DatabaseUtil.getConnection();
	/**
	 * 调用分类dao属性
	 */
	EasybuyOrderDetailDao easybuyOrderDetailDao=new EasybuyOrderDetailDaoImpl(conn);
	/**
	 * 通过orderId查询所有订单详情信息
	 * @param orderId
	 * @return
	 */
	@Override
	public List<EasybuyOrderDetail>findEasybuyOrderDetailList(Integer orderId) {
		// TODO Auto-generated method stub
		return easybuyOrderDetailDao.getEasybuyOrderDetailList(orderId);
	}
	

}
