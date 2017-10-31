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

	//根据商品分类级别id向数据库查询对应商品信息
	public List<EasybuyProduct> getEasybuyProdouctsById(Integer idcategoryLevelId);
	
	
}
