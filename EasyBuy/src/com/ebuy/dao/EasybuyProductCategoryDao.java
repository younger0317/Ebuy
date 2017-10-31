package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyProductCategory;

/**
 * 商品分类Dao
 * @author Administrator
 *
 */
public interface EasybuyProductCategoryDao {
	/**
	 * 查询所有一级份分类
	 */
	List<EasybuyProductCategory> getType1IbAll();
	/**
	 * 查询所有二级份分类
	 */
	List<EasybuyProductCategory> getType2IbAll();
	/**
	 * 查询所有三级份分类
	 */
	List<EasybuyProductCategory> getType3IbAll();
	/**
	 * 通过parentId查询
	 */
	List<EasybuyProductCategory> getParentIdAll(int parentId);
}
