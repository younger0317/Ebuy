package com.ebuy.service;

import java.util.List;

import com.ebuy.entity.EasybuyNews;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-31
 * 资讯业务接口
 *
 */
public interface EasybuyNewsService {
	
	public List<EasybuyNews> getFiveNews();

}
