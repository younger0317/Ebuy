package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyOrderDetailDao;
import com.ebuy.entity.EasybuyOrderDetail;

public class EasybuyOrderDetailDaoImpl extends BaseDao<EasybuyOrderDetail> implements EasybuyOrderDetailDao {

	public EasybuyOrderDetailDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 通过orderId查询所有订单详情信息
	 * @param orderId
	 * @return
	 */
	@Override
	public List<EasybuyOrderDetail> getEasybuyOrderDetailList(Integer orderId) {
		String sql="select * from easybuy_order_detail where orderId=?";
		return super.executeQuery(sql,orderId);
	}

	@Override
	public EasybuyOrderDetail getEntity(ResultSet rs) {
		EasybuyOrderDetail easybuyOrderDetail=null;
		if(rs!=null){
			
			try {
				int id = rs.getInt("id");
				int orderId =rs.getInt("orderId");
				int productId =rs.getInt("productId");
				int quantity =rs.getInt("quantity");
				float cost = rs.getFloat("cost");
				easybuyOrderDetail=new EasybuyOrderDetail(id, orderId, productId, quantity, cost);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return easybuyOrderDetail;
	}



}
