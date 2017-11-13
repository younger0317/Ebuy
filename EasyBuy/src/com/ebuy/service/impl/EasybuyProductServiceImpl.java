package com.ebuy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ebuy.dao.EasybuyProductDao;
import com.ebuy.dao.impl.EasybuyProductImpl;
import com.ebuy.entity.EasybuyProduct;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.util.DatabaseUtil;
import com.ebuy.util.MybatisUtil;
/**
 * 
 * @author anwensheng
 * @version 1.0 20171031
 *商品信息业务层实现类
 */
public class EasybuyProductServiceImpl implements EasybuyProductService {
	
	//private Connection conn=null;//获取连接池对象
	 //获取商品信息实现类对象
	@Override
	public List<EasybuyProduct> findEasybuyProdouctsById(
		Integer categoryLevelId,int currentNo,int pageSize) {
		
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		List<EasybuyProduct> productList = sqlSession.getMapper(EasybuyProductDao.class).getEasybuyProdouctsById(categoryLevelId, currentNo, pageSize);
		MybatisUtil.Close(sqlSession);
		return productList;
		
		
		
		
		
		
		
		
		
		
		
		/*
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
		return productList;*/
	}
	@Override
	//查询商品总条数
	public int findProductCount(Integer categoryLevelId) {
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		
		
		int count =sqlSession.getMapper(EasybuyProductDao.class).getProductCount(categoryLevelId);
		MybatisUtil.Close(sqlSession);
		return count;
		
	/*	conn=DatabaseUtil.getConnection();
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
		
		return count;*/
	}
	//产品增加业务实现类
	public int addProduct(EasybuyProduct easybuyProduct) {
		
SqlSession sqlSession = MybatisUtil.createSqlSession();
		
		
		int count =sqlSession.getMapper(EasybuyProductDao.class).addProduct(easybuyProduct);
		sqlSession.commit();
		MybatisUtil.Close(sqlSession);
		return count;
		/*conn=DatabaseUtil.getConnection();
		int count=0;
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			//调用实现类方法
			count = easybuyProductDao.addProduct(easybuyProduct);
			//判断商品列表是否为空，若不为空设置事务提交
			if (count>0) {
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
			
		}*/
	}
	//产品删除业务实现类
	public int delProduct(int id) {
		/*conn=DatabaseUtil.getConnection();
		int count=0;
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			//调用实现类方法
			count = easybuyProductDao.delProduct(id);
			//判断商品列表是否为空，若不为空设置事务提交
			if (count>0) {
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
			
		}*/
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		
		
		int count =sqlSession.getMapper(EasybuyProductDao.class).delProduct(id);
		sqlSession.commit();
		MybatisUtil.Close(sqlSession);
		return count;
	}
	//产品更新修改业务实现类
	public int updatProduct(EasybuyProduct easybuyProduct) {
		
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		
		int count =sqlSession.getMapper(EasybuyProductDao.class).updatProduct(easybuyProduct);
		sqlSession.commit();
		MybatisUtil.Close(sqlSession);
		return count;
		
		
	/*	conn=DatabaseUtil.getConnection();
		int count=0;
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			//调用实现类方法
			count = easybuyProductDao.updatProduct(easybuyProduct);
			//判断商品列表是否为空，若不为空设置事务提交
			if (count>0) {
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
		return count;*/
	}
	//产品列表查询业务实现类
	public List<EasybuyProduct> findProductList(int currentNo,int pageSize) {
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		int sum=(currentNo-1)*pageSize;
		 List<EasybuyProduct> productList2 = sqlSession.getMapper(EasybuyProductDao.class).getProductList(sum, pageSize);
		MybatisUtil.Close(sqlSession);
		return productList2;
		/*conn=DatabaseUtil.getConnection();
		List<EasybuyProduct> productList=null;
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			//调用实现类方法
			productList = easybuyProductDao.getProductList(currentNo, pageSize);
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
		return productList;*/
	}
	//产品总数量查询业务实现类
	public int findProductTotal() {
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		int total = sqlSession.getMapper(EasybuyProductDao.class).getProductTotal();
		MybatisUtil.Close(sqlSession);
		return total;
		
		
		
		
	/*	conn=DatabaseUtil.getConnection();
		int count=0;
		
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			count = easybuyProductDao.getProductTotal();
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
		
		return count;*/
	}
	
	
	//根据商品id查询商品信息
	public EasybuyProduct findProductById(int id) {
		SqlSession sqlSession = MybatisUtil.createSqlSession();
		EasybuyProduct product = sqlSession.getMapper(EasybuyProductDao.class).getProductById(id);
		MybatisUtil.Close(sqlSession);
		return product;
		
		
	/*	conn=DatabaseUtil.getConnection();
		EasybuyProduct ebp=new EasybuyProduct();
		try {
			//关闭自动提交事物
			conn.setAutoCommit(false);
			//创建业务层商品类对象
			EasybuyProductDao easybuyProductDao=new EasybuyProductImpl(conn);
			ebp = easybuyProductDao.getProductById(id);
			if (ebp!=null) {
				
				conn.commit();
			}
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
		
		return ebp;*/
	}
	

	
}
