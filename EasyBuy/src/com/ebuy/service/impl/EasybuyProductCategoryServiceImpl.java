package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ebuy.dao.EasybuyProductCategoryDao;
import com.ebuy.dao.impl.EasybuyProductCategoryDaoImpl;
import com.ebuy.dao.newdao.EasybuyProductCategoryMapperDao;
import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyProductCategoryService;
import com.ebuy.util.DatabaseUtil;
import com.ebuy.util.MybatisUtil;
/**
 * 分类接口实现类
 * @author Administrator
 *
 */
public class EasybuyProductCategoryServiceImpl implements
		EasybuyProductCategoryService {
	//获取数据库链接
	//Connection conn = DatabaseUtil.getConnection();
	/**
	 * 调用分类dao属性
	 */
	//private EasybuyProductCategoryDao epcd=new EasybuyProductCategoryDaoImpl(conn);
	@Override
	public List<EasybuyProductCategory> findType1IbAll() {
		SqlSession session = MybatisUtil.createSqlSession();
		List<EasybuyProductCategory> list = session.getMapper(EasybuyProductCategoryMapperDao.class).getType1IbAll();
		MybatisUtil.Close(session);
		return list;
	}

	@Override
	public List<EasybuyProductCategory> findType2IbAll() {
		SqlSession session = MybatisUtil.createSqlSession();
		List<EasybuyProductCategory> list = session.getMapper(EasybuyProductCategoryMapperDao.class).getType2IbAll();
		MybatisUtil.Close(session);
		return list;
	}

	@Override
	public List<EasybuyProductCategory> findType3IbAll() {
		SqlSession session = MybatisUtil.createSqlSession();
		List<EasybuyProductCategory> list = session.getMapper(EasybuyProductCategoryMapperDao.class).getType3IbAll();
		MybatisUtil.Close(session);
		return list;
	}
	//查询所有分类
	@Override
	public Page<EasybuyProductCategory> getCategotyAll(int currentNo,int pageSize) {
		Page<EasybuyProductCategory> page = new Page<EasybuyProductCategory>();
		SqlSession session = MybatisUtil.createSqlSession();
		int sun=(currentNo-1)*pageSize;
		List<EasybuyProductCategory> list = session.getMapper(EasybuyProductCategoryMapperDao.class).getCategotyByPageAll(sun, pageSize);
		
		
		//获取总条数
		
		int totalCount = session.getMapper(EasybuyProductCategoryMapperDao.class).countUser();
		//设置page参数
		page.setCurrentNo(currentNo);
		page.setPageSize(pageSize);
		page.setTotalCount(totalCount);
		page.setTotalPageCount(totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize+1 );
		page.setPageList(list);
		//关闭资源
		MybatisUtil.Close(session);
		return page;
	}
	/**
	 * 增加
	 */
	@Override
	public int addCategoty(EasybuyProductCategory epc) {
		//EasybuyProductCategory category = epcd.getCategotyByName(epc);
		SqlSession session = MybatisUtil.createSqlSession();
		EasybuyProductCategory category = session.getMapper(EasybuyProductCategoryMapperDao.class).getCategotyByName(epc);
		String name = epc.getName();
		if(category!=null){
			
			String name2 = category.getName();
			if(name2!=null){			
				if(name.equals(name2)){
					return 0;
				}
			}
		}
		
		int addCategoty = session.getMapper(EasybuyProductCategoryMapperDao.class).addCategoty(epc);
		session.commit();
		MybatisUtil.Close(session);
		return addCategoty;
		
	
	}
	/**
	 * 删除分类
	 */
	@Override
	public int deleteCategoty(int id) {
		//List<EasybuyProductCategory> list = epcd.getParentIdAll(id);
		SqlSession session = MybatisUtil.createSqlSession();
		List<EasybuyProductCategory> list = session.getMapper(EasybuyProductCategoryMapperDao.class).getParentIdAll(id);
		if(list!=null && list.size()>0){
			MybatisUtil.Close(session);
			return 0;
		}
		int deleteCategoty = session.getMapper(EasybuyProductCategoryMapperDao.class).deleteCategoty(id);
			session.commit();
			MybatisUtil.Close(session);
			return deleteCategoty;
		
	}

	@Override
	public List<EasybuyProductCategory> findAll() {
		SqlSession session = MybatisUtil.createSqlSession();
		List<EasybuyProductCategory> all = session.getMapper(EasybuyProductCategoryMapperDao.class).getAll();
		MybatisUtil.Close(session);
		return all;
	}

	/**
	 * @author anwensheng
	 * @version 1.0 2017 11 02
	 * 通过名字查询id
	 */
	public int findIdByName(String name) {
		SqlSession session = MybatisUtil.createSqlSession();
		int count=0;
		count=session.getMapper(EasybuyProductCategoryMapperDao.class).getIdByName(name);
		MybatisUtil.Close(session);
		return count;
	}

	@Override
	public int deleteCategoty(EasybuyProductCategory epc) {
		return 0;
	}

}
