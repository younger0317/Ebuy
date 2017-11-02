package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyProduct;

/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *
 */

public interface EasybuyProductDao {

	//根据商品分类级别向数据库查询对应商品信息
	public List<EasybuyProduct> getEasybuyProdouctsById(Integer categoryLevelId,int currentNo,int pageSize);
	
	//获取商品总条数
	public int getProductCount(Integer categoryLevelId);
	
	
}
