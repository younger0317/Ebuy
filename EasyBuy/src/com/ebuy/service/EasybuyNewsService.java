package com.ebuy.service;

import java.util.List;

import com.ebuy.entity.EasybuyNews;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-31
 * 资讯业务接口
 *
 */
public interface EasybuyNewsService {
	
	/**
	 * 获取首页资讯
	 * @return
	 */
	public List<EasybuyNews> getFiveNews();
	
	/**
	 * 获取资讯分页
	 * @param currentNo
	 * @param pageSize
	 * @return
	 */
	public Page<EasybuyNews> findPageList(int currentNo,int pageSize);
	
	/**
	 * 获取资讯对象
	 * @param id
	 * @return
	 */
	public EasybuyNews findNewsById(int id);

}
