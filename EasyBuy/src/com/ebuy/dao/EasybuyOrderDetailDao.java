package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyOrderDetail;

/**
 * 订单详情
 * @author Amerader 李胜
 *
 */
public interface EasybuyOrderDetailDao {
	
	/**
	 * 通过orderId查询所有订单详情信息
	 * @param orderId
	 * @return
	 */
	public List<EasybuyOrderDetail> getEasybuyOrderDetailList(Integer orderId);

}
