package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ebuy.dao.EasybuyNewsDao;
import com.ebuy.dao.EasybuyUserDao;
import com.ebuy.dao.impl.EasybuyNewsDaoImpl;
import com.ebuy.dao.impl.EasybuyUserDaoImpl;
import com.ebuy.entity.EasybuyNews;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyNewsService;
import com.ebuy.util.DatabaseUtil;
import com.ebuy.util.MybatisUtil;
/**
 * 
 * @author linbingyang
 * @version 1.1 2017-11-3
 * 咨询业务实现类
 *
 */
public class EasybuyNewsServiceImpl implements EasybuyNewsService {
	
	private SqlSession sqlSession;
	/**
	 * 获取首页资讯
	 */
	@Override
	public List<EasybuyNews> getFiveNews() {
		//获取链接
		Connection conn = DatabaseUtil.getConnection();
		//创建对象
		EasybuyNewsDao newsDao = new EasybuyNewsDaoImpl(conn);
		
		sqlSession = MybatisUtil.createSqlSession();
		
		//业务逻辑
		List<EasybuyNews> list = null;
		String sql = "order by createTime limit 5";
		list = newsDao.getList(sql);
		System.out.println(">>>>>>>获取的list"+list.size());
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return list;
	}
	
	/**
	 * 获取当前页资讯
	 */
	@Override
	public Page<EasybuyNews> findPageList(int currentNo, int pageSize) {
		Page<EasybuyNews> page = new Page<EasybuyNews>();
		//获取数据库链接
		Connection conn = DatabaseUtil.getConnection();
		//创建Dao对象
		EasybuyNewsDao newsDao = new EasybuyNewsDaoImpl(conn);
		//业务流程
		String sql = "order by createTime desc limit ?,? ";
		//获取集合
		List<EasybuyNews> pageList = newsDao.getList(sql, (currentNo-1)*pageSize,pageSize);
		//获取总条数
		int totalCount = newsDao.countNews();
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
	 * 获取资讯
	 */
	@Override
	public EasybuyNews findNewsById(int id) {
		EasybuyNews news = null;
		//获取链接
		Connection conn = DatabaseUtil.getConnection();
		//创建对象
		EasybuyNewsDao newsDao = new EasybuyNewsDaoImpl(conn);
		//业务流程
		String sql = "where id = ?";
		List<EasybuyNews> list = newsDao.getList(sql, id);
		if(list != null && list.size()>0){
			news = list.get(0);
		}
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return news;
	}

}
