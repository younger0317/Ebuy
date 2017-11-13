package com.ebuy.dao.newdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ebuy.entity.EasybuyProductCategory;

public interface EasybuyProductCategoryMapperDao {
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
	List<EasybuyProductCategory> getParentIdAll(@Param("parentId")int parentId);
	/**
	 * 查询所有分页的分类
	 */
	List<EasybuyProductCategory> getCategotyByPageAll(@Param("currentNo")int currentNo,@Param("pageSize")int pageSize);
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
	int deleteCategoty(@Param("id")int id);
	/**
	 * 通过名字查询分类
	 */
	EasybuyProductCategory getCategotyByName(EasybuyProductCategory epc);
	
	
	/**
	 * @author anwensheng
	 * @version 1.0 2017 11 02
	 * 通过名字查询id
	 */
	public int getIdByName(@Param("name")String name);
    /*
	 * 查询所有分类
	 * 
	 */
	List<EasybuyProductCategory> getAll();

}
