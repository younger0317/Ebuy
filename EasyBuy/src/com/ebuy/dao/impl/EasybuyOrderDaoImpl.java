package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyOrderDao;
import com.ebuy.entity.EasybuyOrder;

public class EasybuyOrderDaoImpl extends BaseDao<EasybuyOrder> implements EasybuyOrderDao {

	public EasybuyOrderDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 查询订单详情所有信息
	 * @return
	 */
	@Override
	public List<EasybuyOrder> getEasybuyOrdersList() {
		String sql="select * from easybuy_order";
		return super.executeQuery(sql);
	}

	@Override
	public EasybuyOrder getEntity(ResultSet rs) {
		EasybuyOrder easybuyOrder=null;
		if(rs!=null){		
			try {
				int id = rs.getInt("id");
				int userId = rs.getInt("userId");
				String loginName = rs.getString("loginName");
				String userAddress = rs.getString("userAddress");
				Date createTime=rs.getDate("createTime");
				float cost = rs.getFloat("cost");
				String serialNumber = rs.getString("serialNumber");
				easybuyOrder=new EasybuyOrder(id, userId, loginName, userAddress, createTime, cost, serialNumber);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		return easybuyOrder;
	}

}
