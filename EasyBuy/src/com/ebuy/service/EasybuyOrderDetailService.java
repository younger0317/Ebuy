package com.ebuy.service;

import java.util.List;

import com.ebuy.entity.EasybuyOrderDetail;

public interface EasybuyOrderDetailService {
	/**
	 * 通过orderId查询所有订单详情信息
	 * @param orderId
	 * @return
	 */
	public List<EasybuyOrderDetail> findEasybuyOrderDetailList(Integer orderId);

}
