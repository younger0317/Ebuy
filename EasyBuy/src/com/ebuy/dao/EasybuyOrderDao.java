package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyOrder;

/**
 * 订单
 * @author Amerader 李胜
 *
 */

public interface EasybuyOrderDao {
	
	
	/**
	 * 查询订单所有信息
	 * @return
	 */
	public List<EasybuyOrder> getEasybuyOrdersList();
}
