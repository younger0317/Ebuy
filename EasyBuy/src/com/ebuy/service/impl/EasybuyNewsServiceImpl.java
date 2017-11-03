package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import com.ebuy.dao.EasybuyNewsDao;
import com.ebuy.dao.impl.EasybuyNewsDaoImpl;
import com.ebuy.entity.EasybuyNews;
import com.ebuy.service.EasybuyNewsService;
import com.ebuy.util.DatabaseUtil;

public class EasybuyNewsServiceImpl implements EasybuyNewsService {

	@Override
	public List<EasybuyNews> getFiveNews() {
		//获取链接
		Connection conn = DatabaseUtil.getConnection();
		//创建对象
		EasybuyNewsDao newsDao = new EasybuyNewsDaoImpl(conn);
		
		//业务逻辑
		List<EasybuyNews> list = null;
		String sql = "order by createTime limit 5";
		list = newsDao.getList(sql);
		System.out.println(">>>>>>>获取的list"+list.size());
		//关闭资源
		DatabaseUtil.closeAll(conn, null, null);
		return list;
	}

}
