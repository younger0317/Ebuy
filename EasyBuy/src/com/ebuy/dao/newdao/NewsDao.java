package com.ebuy.dao.newdao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ebuy.entity.EasybuyNews;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-11-11
 * 资讯dao（mybatis）
 *
 */
public interface NewsDao {
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
	public int delNews(@Param("id")int id);
	
	/**
	 * 修改新闻
	 * @param news      修改的新闻对象
	 * @return			更新行数
	 */
	public int updateNews(EasybuyNews news);
	
	/**
	 * 查找分页新闻数据
	 * @param currentNo 开始下标
	 * @param pageSize	页大小
	 * @return          当前页新闻集合
	 */
	public List<EasybuyNews> getPageList(@Param("currentNo")Integer currentNo,@Param("pageSize")Integer pageSize);
	
	/**
	 * 统计记录总数
	 * @return 统计的条数
	 */
	public int countNews();
	
	/**
	 * 通过id找资讯
	 * @param id 资讯id
	 * @return	 资讯对象	
	 */
	public EasybuyNews findNewsById(@Param("id")Integer id);
}
