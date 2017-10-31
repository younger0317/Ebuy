package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyProductDao;
import com.ebuy.entity.EasybuyProduct;
/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *产品信息数据库访问层实现类
 */

public class EasybuyProductImpl extends BaseDao<EasybuyProduct> implements EasybuyProductDao {

	public EasybuyProductImpl(Connection conn) {
		super(conn);
	}

	//重写根据级联id查询产品列表
	public List<EasybuyProduct> getEasybuyProdouctsById(
			Integer idcategoryLevelId) {
		List<EasybuyProduct> easybuyProductList=new ArrayList<EasybuyProduct>();
		String sql="select * from easybuy_product where idcategoryLevel3Id=?";
		easybuyProductList=super.executeQuery(sql, idcategoryLevelId);
		return easybuyProductList;
	}

	//重写获取产品类的方法
	public EasybuyProduct getEntity(ResultSet rs) {
		EasybuyProduct easybuyProduct=null;
		try {
			if (rs!=null) {
				int id = rs.getInt("id");
				int stock = rs.getInt("stock");
				int categoryLevel1Id = rs.getInt("categoryLevel1Id");
				int categoryLevel2Id = rs.getInt("categoryLevel2Id");
				int categoryLevel3Id = rs.getInt("categoryLevel3Id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String fileName = rs.getString("fileName");
				int isDelete = rs.getInt("isDelete");
				float price = rs.getFloat("price");
				easybuyProduct=new EasybuyProduct(id, name, description, price, stock, 
				categoryLevel1Id, categoryLevel2Id, categoryLevel3Id, fileName, isDelete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return easybuyProduct;
		
	}

}
