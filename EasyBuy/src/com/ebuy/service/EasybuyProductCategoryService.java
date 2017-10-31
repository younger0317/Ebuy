package com.ebuy.service;

import java.util.List;
/**
 * 分类业务接口
 */
import com.ebuy.entity.EasybuyProductCategory;

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
}
