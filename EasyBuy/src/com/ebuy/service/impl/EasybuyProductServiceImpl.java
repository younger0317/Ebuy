package com.ebuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ebuy.dao.EasybuyProductDao;
import com.ebuy.dao.impl.EasybuyProductImpl;
import com.ebuy.entity.EasybuyProduct;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.util.DatabaseUtil;
/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *商品信息业务层实现类
 */
public class EasybuyProductServiceImpl implements EasybuyProductService {
	
	private Connection conn=null;//获取连接池对象
	 //获取商品信息实现类对象
	@Override
	public List<EasybuyProduct> findEasybuyProdouctsById(
			Integer categoryLevelId,int currentNo,int pageSize) {
		conn=DatabaseUtil.getConnection();
		List<EasybuyProduct> productList=null;
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			//调用实现类方法
			productList = easybuyProductDao.getEasybuyProdouctsById(categoryLevelId,currentNo, pageSize);
			//判断商品列表是否为空，若不为空设置事务提交
			if (productList!=null&&productList.size()>0) {
			conn.commit();
		}
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn!=null) {
				try {
					//如果列表为空 ，执行事务回滚 
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally{
			DatabaseUtil.closeAll(conn, null, null);
			
		}
		return productList;
	}
	@Override
	//查询商品总条数
	public int findProductCount(Integer categoryLevelId) {
		conn=DatabaseUtil.getConnection();
		int count=0;
		
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			count = easybuyProductDao.getProductCount(categoryLevelId);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally{
			
			DatabaseUtil.closeAll(conn, null, null);
		}
		
		return count;
	}
	

	
}
