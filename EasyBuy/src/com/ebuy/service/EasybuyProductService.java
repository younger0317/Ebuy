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
		public List<EasybuyProduct> findEasybuyProdouctsById(Integer categoryLevelId,int currentNo,int pageSize);

		//获取商品总条数
		public int findProductCount(Integer categoryLevelId);
		//增加(上架)商品
		public int addProduct(EasybuyProduct easybuyProduct);
		//删除商品
		public int delProduct(int id);
		//修改商品
		public int updatProduct(EasybuyProduct easybuyProduct);
		//商品查询
		public List<EasybuyProduct> findProductList(int currentNo,int pageSize);
		//商品分页总数查询
		public int findProductTotal();
		//根据商品id查询商品信息
		public EasybuyProduct findProductById(int id);
		
	
}
