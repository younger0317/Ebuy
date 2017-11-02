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
	}
	
	/**
	 * 添加新闻
	 */
	@Override
	public int addNews(EasybuyNews news) {
		int update = 0;
		String sql = "insert into easybuy_news(title,content,createTime) values (?,?,?)";
		update = super.executeUpdate(sql, news.getTitle(),news.getContent(),news.getCreateTime());
		return update;
	}
	
	/**
	 * 删除新闻
	 */
	@Override
	public int delNews(int id) {
		int update = 0;
		String sql = "delete from easybuy_news where id = ?";
		update = super.executeUpdate(sql, id);
		return update;
	}
	
	/**
	 * 更新新闻
	 */
	@Override
	public int updateNews(String appendSql, Object... params) {
		int update = 0;
		StringBuffer sql = new StringBuffer("update easybuy_news ");
		sql.append(appendSql);
		update = super.executeUpdate(sql.toString(), params);
		return update;
	}
	
	/**
	 * 获取新闻列表
	 */
	@Override
	public List<EasybuyNews> getList(String appendSql, Object... params) {
		List<EasybuyNews> list = null;
		StringBuffer sql = new StringBuffer("select * from easybuy_news ");
		list = super.executeQuery(sql.toString(), params);
		return list;
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
