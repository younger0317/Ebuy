package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import com.ebuy.dao.EasybuyProductCategoryDao;
import com.ebuy.dao.impl.EasybuyProductCategoryDaoImpl;
import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.service.EasybuyProductCategoryService;
import com.ebuy.util.DatabaseUtil;
/**
 * 分类接口实现类
 * @author Administrator
 *
 */
public class EasybuyProductCategoryServiceImpl implements
		EasybuyProductCategoryService {
	//获取数据库链接
	Connection conn = DatabaseUtil.getConnection();
	/**
	 * 调用分类dao属性
	 */
	private EasybuyProductCategoryDao epcd=new EasybuyProductCategoryDaoImpl(conn);
	@Override
	public List<EasybuyProductCategory> findType1IbAll() {
		
		return epcd.getType1IbAll();
	}

	@Override
	public List<EasybuyProductCategory> findType2IbAll() {
	
		 List<EasybuyProductCategory> list = epcd.getType2IbAll();
		return list;
	}

	@Override
	public List<EasybuyProductCategory> findType3IbAll() {
		// TODO Auto-generated method stub
		return epcd.getType3IbAll();
	}

}
