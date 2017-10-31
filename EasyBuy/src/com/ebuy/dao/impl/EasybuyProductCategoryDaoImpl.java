package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyProductCategoryDao;
import com.ebuy.entity.EasybuyProduct;
import com.ebuy.entity.EasybuyProductCategory;

public class EasybuyProductCategoryDaoImpl extends BaseDao<EasybuyProductCategory> implements
		EasybuyProductCategoryDao {

	public EasybuyProductCategoryDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 一级
	 */
	@Override
	public List<EasybuyProductCategory> getType1IbAll() {
		String sql="select * from easybuy_product_category where type=?";
		List<EasybuyProductCategory> list = super.executeQuery(sql,1);
		
		return list ;
	}

	@Override
	public EasybuyProductCategory getEntity(ResultSet rs) {
		EasybuyProductCategory ebp=null;
		if(rs!=null){
			try {
				int id = rs.getInt("id");
				int parentId = rs.getInt("parentId");
				int type = rs.getInt("type");
				String name = rs.getString("name");
				//String iconClass = rs.getString("iconClass");
				ebp=new EasybuyProductCategory(id, name, parentId, type);
				//ebp.setIconClass(iconClass);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ebp;
	}
	/**
	 * 二级分类
	 */
	@Override
	public List<EasybuyProductCategory> getType2IbAll() {
		String sql="select * from easybuy_product_category where type=?";
		List<EasybuyProductCategory> list = super.executeQuery(sql,2);
		
		return list ;
	}
	/**
	 * 三级分类
	 */
	@Override
	public List<EasybuyProductCategory> getType3IbAll() {
		String sql="select * from easybuy_product_category where type=?";
		List<EasybuyProductCategory> list = super.executeQuery(sql,3);
		
		return list ;
	}
	@Override
	public List<EasybuyProductCategory> getParentIdAll(int parentId) {
		String sql="select * from easybuy_product_category where type=?";
		List<EasybuyProductCategory> list = super.executeQuery(sql,parentId);
		
		return list ;
	}

}
