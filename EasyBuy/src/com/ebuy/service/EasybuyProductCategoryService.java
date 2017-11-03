package com.ebuy.service;

import java.util.List;

/**
 * 分类业务接口
 */
import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.entity.Page;

public interface EasybuyProductCategoryService {
	/**
	 * 查询所有一级份分类
	 */
	List<EasybuyProductCategory> findType1IbAll();
	/**
	 * 查询所有二级份分类
	 */
	List<EasybuyProductCategory> findType2IbAll();
	/**
	 * 查询所有三级份分类
	 */
	List<EasybuyProductCategory> findType3IbAll();
	/**
	 * 查询所有的分类
	 */
	Page<EasybuyProductCategory> getCategotyAll(int currentNo,int pageSize);
	/**
	 * 增加分类
	 */
	int addCategoty(EasybuyProductCategory epc);
	/**
	 * 删除分类
	 */
	int deleteCategoty(EasybuyProductCategory epc);
	/**
	 * @author anwensheng
	 * @version 1.0 2017 11 02
	 * 通过名字查询id
	 */
	public int findIdByName(String name);
}
