package com.ebuy.service;

import java.util.List;

import com.ebuy.entity.EasybuyOrder;

public interface EasybuyOrderService {

	/**
	 * 查询订单所有信息
	 * @return
	 */
	public List<EasybuyOrder> findEasybuyOrdersList();
}
