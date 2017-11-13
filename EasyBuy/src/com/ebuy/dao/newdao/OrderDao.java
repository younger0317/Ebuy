package com.ebuy.dao.newdao;

import java.util.List;

import com.ebuy.entity.EasybuyOrder;
import com.ebuy.entity.EasybuyOrderDetail;

public interface OrderDao {
	
	public List<EasybuyOrder> getEasybuyOrdersList();	
}
