package com.ebuy.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.BaseDao;
import com.ebuy.dao.EasybuyNewsDao;
import com.ebuy.entity.EasybuyNews;
/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-30
 * 新闻Dao实现类
 *
 */
public class EasybuyNewsDaoImpl extends BaseDao<EasybuyNews> implements EasybuyNewsDao {
	/**
	 * 继承父类构造方法
	 * @param conn
	 */
	public EasybuyNewsDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 添加新闻
	 */
	@Override
	public int addNews(EasybuyNews news) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 删除新闻
	 */
	@Override
	public int delNews(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 更新新闻
	 */
	@Override
	public int updateNews(String appendSql, Object... params) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 获取新闻列表
	 */
	@Override
	public List<EasybuyNews> getList(String appendSql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 获取新闻对象
	 */
	@Override
	public EasybuyNews getEntity(ResultSet rs) {
		EasybuyNews news = null ;
		if(rs != null){
			try {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String createTime = rs.getString("createTime");
				
				news= new EasybuyNews();
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);
				news.setCreateTime(createTime);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return news;
	}

}
