package com.ebuy.dao;

import java.util.List;

import com.ebuy.entity.EasybuyNews;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-31
 * 资讯Dao接口
 *
 */
public interface EasybuyNewsDao {
	/**
	 * 增加新闻
	 * @param news 新闻对象
	 * @return 更新行数
	 */
	public int addNews(EasybuyNews news);
	
	/**
	 * 删除新闻
	 * @param id 新闻id
	 * @return	更新行数
	 */
	public int delNews(int id);
	
	/**
	 * 修改新闻
	 * @param appendSql sql拼接语句
	 * @param params	参数列表
	 * @return			更新行数
	 */
	public int updateNews(String appendSql,Object...params);
	
	/**
	 * 查找新闻数据
	 * @param appendSql sql拼接语句
	 * @param params	参数列表
	 * @return          新闻集合
	 */
	public List<EasybuyNews> getList(String appendSql,Object...params);
	
	/**
	 * 统计记录总数
	 * @return 统计的条数
	 */
	public int countNews();
}
