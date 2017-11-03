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
	/**
	 * 查询所有的分类
	 */
	List<EasybuyProductCategory> getCategotyAll(String appendSql,Object...params);
	/**
	 * 增加分类
	 */
	int addCategoty(EasybuyProductCategory epc);
	/**
	 * 统计记录总数
	 * @return 统计的条数
	 */
	public int countUser();
	/**
	 * 删除分类
	 */
	int deleteCategoty(int id);
	/**
	 * 通过名字查询分类
	 */
	EasybuyProductCategory getCategotyByName(EasybuyProductCategory epc);
	/**
	 * 查询所有分类
	 * 
	 */
	List<EasybuyProductCategory> getAll();
}
