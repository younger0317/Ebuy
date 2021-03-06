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

	//重写根据级联id,当前页currentNo, 页面容量pageSize查询产品列表
	public List<EasybuyProduct> getEasybuyProdouctsById(
			Integer categoryLevelId,int currentNo,int pageSize) {
		List<EasybuyProduct> easybuyProductList=new ArrayList<EasybuyProduct>();
		String sql="select * from easybuy_product where categoryLevel3Id=? limit ?,?";
		Object[] params={categoryLevelId,(currentNo-1)*pageSize,pageSize};
		easybuyProductList=super.executeQuery(sql, params);
		return easybuyProductList;
	}

	//获取商品总条数
		public int getProductCount(Integer categoryLevelId){
			int count=0;
			String sql="select count(1) from easybuy_product where categoryLevel3Id=?";
			Object[] params={categoryLevelId};
			ResultSet rs=super.resultQuery(sql, params);
			try {
				while (rs.next()) {
					count=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
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

	//增加(上架)商品
	public int addProduct(EasybuyProduct easybuyProduct) {
		int count=0;
		String sql="insert into easybuy_product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName) values(?,?,?,?,?,?,?,?)";
		Object[] params={easybuyProduct.getName(),easybuyProduct.getDescription(),easybuyProduct.getPrice(),
						easybuyProduct.getStock(),easybuyProduct.getCategoryLevel1Id(),easybuyProduct.getCategoryLevel2Id(),easybuyProduct.getCategoryLevel3Id(),
						easybuyProduct.getFileName()};
		count=super.executeUpdate(sql, params);
		return count;
	}

	//删除商品
	public int delProduct(int id) {
		int count=0;
		String sql="delete from easybuy_product where id=?";
		Object[] params={id};
		count=super.executeUpdate(sql, params);
		return count;
	}

	//修改商品
	public int updatProduct(EasybuyProduct easybuyProduct) {
		int count =0;
		String sql="update easybuy_product set `name`=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=? where id=? ";
		Object[] params={easybuyProduct.getName(),easybuyProduct.getDescription(),easybuyProduct.getPrice(),
				easybuyProduct.getStock(),easybuyProduct.getCategoryLevel1Id(),easybuyProduct.getCategoryLevel2Id(),easybuyProduct.getCategoryLevel3Id(),
				easybuyProduct.getFileName(),easybuyProduct.getId()};
		count = super.executeUpdate(sql, params);
		return count;
	}

	//商品分页查询
	public List<EasybuyProduct> getProductList(int currentNo,int pageSize) {
		List<EasybuyProduct> productList=new ArrayList<EasybuyProduct>();
		String sql="select * from easybuy_product where 1=1 limit ?,?";
		Object[] params={currentNo,pageSize};
		productList=super.executeQuery(sql, params);
		return productList;
	}

	//商品分页总数查询
	public int getProductTotal() {
		int count=0;
		String sql="select count(1) from easybuy_product ";
	
		ResultSet rs=super.resultQuery(sql, null);
		try {
			while (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	//根据商品id查询商品信息
	public EasybuyProduct getProductById(int id){
		EasybuyProduct ebp=new EasybuyProduct();
		String sql="select * from easybuy_product where id=?";
		Object[] params={id};
		List<EasybuyProduct> productList = super.executeQuery(sql, params);
		if (productList!=null&productList.size()>0) {
			ebp=productList.get(0);
		}
		
		return ebp;
		
				
				
}

	
	

}
