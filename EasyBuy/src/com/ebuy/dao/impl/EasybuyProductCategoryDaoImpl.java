package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyProductCategoryDao;
import com.ebuy.entity.EasybuyProduct;
import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.entity.EasybuyUser;

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
		String sql="select * from easybuy_product_category where parentId=?";
		List<EasybuyProductCategory> list = super.executeQuery(sql,parentId);
		if(list!=null && list.size()>0){
			
			return list ;
		}
		return null;
	}
	//所有分类
	@Override
	public List<EasybuyProductCategory> getCategotyAll(String appendSql,Object...params) {
		List<EasybuyProductCategory> list=null;
		StringBuffer sql = new StringBuffer("select * from easybuy_product_category ");
		sql.append(appendSql);
		list = super.executeQuery(sql.toString(), params);
		return list;
	}
	@Override
	public int addCategoty(EasybuyProductCategory epc) {
		String sql="INSERT INTO easybuy_product_category (name,parentId,type) values(?,?,?)";
		int update = super.executeUpdate(sql, epc.getName(),epc.getParentId(),epc.getType());
		
		return update;
	}
	@Override
	public int countUser() {
		String sql = "select count(1) from easybuy_product_category";
		int totalCount =super.executeQueryCount(sql);
		return totalCount;
	}
	@Override
	public int deleteCategoty(EasybuyProductCategory epc) {
		String sql = "DELETE FROM easybuy_product_category";
		int update = super.executeUpdate(sql, epc.getId());
		return update;
	}
	@Override
	public EasybuyProductCategory getCategotyByName(EasybuyProductCategory epc) {
		String sql = "select * from easybuy_product_category where name=?"; 
		List<EasybuyProductCategory> list = super.executeQuery(sql, epc.getName());
		if(list!=null && list.size()>0){
			
			return list.get(0);
		}
		
		return null;
	}

}
