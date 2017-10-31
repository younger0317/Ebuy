package com.ebuy.service.impl;

import java.sql.Connection;
import java.util.List;

import com.ebuy.dao.EasybuyProductDao;
import com.ebuy.dao.impl.EasybuyProductImpl;
import com.ebuy.entity.EasybuyProduct;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.util.DatabaseUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *商品信息业务层实现类
 */
public class EasybuyProductServiceImpl implements EasybuyProductService {
	
	private Connection conn=DatabaseUtil.getConnection();//获取连接池对象
	private EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);//获取商品信息实现类对象
	@Override
	public List<EasybuyProduct> findEasybuyProdouctsById(
			Integer idcategoryLevelId) {
		
		return easybuyProductDao.getEasybuyProdouctsById(idcategoryLevelId);
	}

	
}
