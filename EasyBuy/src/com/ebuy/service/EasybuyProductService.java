package com.ebuy.service;

import java.util.List;

import com.ebuy.entity.EasybuyProduct;

/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *商品信息业务层接口类
 */
public interface EasybuyProductService {
	
	//根据商品分类级别id向数据库查询对应商品信息
		public List<EasybuyProduct> findEasybuyProdouctsById(Integer idcategoryLevelId);

}
