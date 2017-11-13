package com.ebuy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ebuy.entity.EasybuyProduct;

/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *
 */

public interface EasybuyProductDao {

	//根据商品分类级别向数据库查询对应商品信息
	//public List<EasybuyProduct> getEasybuyProdouctsById(Integer categoryLevelId,int currentNo,int pageSize);
	public List<EasybuyProduct> getEasybuyProdouctsById(@Param("categoryLevelId")Integer categoryLevelId,@Param("currentNo")int currentNo,@Param("pageSize")int pageSize);
	
	
	//根据商品分类id获取商品总条数
	public int getProductCount(@Param("categoryLevelId")Integer categoryLevelId);
	//增加(上架)商品
	public int addProduct(EasybuyProduct easybuyProduct);
	//删除商品
	public int delProduct(@Param("id")int id);
	//修改商品
	public int updatProduct(EasybuyProduct easybuyProduct);
	//商品分页查询
	public List<EasybuyProduct> getProductList(@Param("currentNo")int currentNo,@Param("pageSize")int pageSize);
	//public List<EasybuyProduct> getProducts(@Param("currentNo")int point,@Param("pageSize")int pageSize);
	//商品分页总数查询
	public int getProductTotal();
	//根据商品id查询商品信息
	public EasybuyProduct getProductById(@Param("id")int id);
}
