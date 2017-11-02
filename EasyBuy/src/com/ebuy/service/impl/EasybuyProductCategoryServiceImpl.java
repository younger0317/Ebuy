package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import com.ebuy.dao.EasybuyProductCategoryDao;
import com.ebuy.dao.impl.EasybuyProductCategoryDaoImpl;
import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
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
	//查询所有分类
	@Override
	public Page<EasybuyProductCategory> getCategotyAll(int currentNo,int pageSize) {
		Page<EasybuyProductCategory> page = new Page<EasybuyProductCategory>();
		//业务流程
		String sql = "limit ?,? ";
		//获取集合
		List<EasybuyProductCategory> pageList = epcd.getCategotyAll(sql, (currentNo-1)*pageSize,pageSize);
		//获取总条数
		int totalCount = epcd.countUser();
		//设置page参数
		page.setCurrentNo(currentNo);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setTotalPageCount(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1 );
		page.setPageList(pageList);
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return page;
	}
	/**
	 * 增加
	 */
	@Override
	public int addCategoty(EasybuyProductCategory epc) {
		EasybuyProductCategory category = epcd.getCategotyByName(epc);
		String name = epc.getName();
		String name2 = category.getName();
		if(name.equals(name2)){
			return 0;
		}else {
			return epcd.addCategoty(epc);
		}
		
	
	}
	/**
	 * 删除分类
	 */
	@Override
	public int deleteCategoty(EasybuyProductCategory epc) {
		List<EasybuyProductCategory> list = epcd.getParentIdAll(epc.getId());
		if(list!=null && list.size()>0){
			
			return 0;
		}
			return epcd.deleteCategoty(epc);
		
	}

}
