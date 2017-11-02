package com.ebuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ebuy.entity.EasybuyProduct;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.service.impl.EasybuyProductServiceImpl;
import com.ebuy.util.Page;
/**
 * 
 * @author anwensheng
 *@version 1.0 20171031
 *产品数据处理器
 */
@WebServlet(urlPatterns={"/productShow"},name="productShow")
public class ProductServlet extends HttpServlet{

	private static Logger log=Logger.getLogger(ProductServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int currentNo=0;
		//获取超链接传过来的id并进行数据类型的转化
		String id = req.getParameter("id");
		//保存该id用来进行翻页查询
		req.setAttribute("id", id);
		Integer categoryLevelId=Integer.parseInt(id);
		//获取商品业务层实现类对象ebps
		EasybuyProductService ebps=new EasybuyProductServiceImpl();
		//获取当前页的页码并进行数据类型转化
		String currentNumber=req.getParameter("currentNo");
		if (currentNumber==null) {
			currentNo=1;
		}else{
			currentNo=Integer.parseInt(currentNumber);
		}
		log.debug("当前页为："+currentNo);
		int pageSize=2;
		//查询对应商品总条数
		int count = ebps.findProductCount(categoryLevelId);
		log.debug("商品总条数"+count);
		//创建商品Page工具的对象并为对象赋值
		Page page=new Page();
		page.setCurrentNo(currentNo);
		page.setPageSize(pageSize);
		page.setCount(count);
		//获取商品总页数
		int totalPageCount=page.getTotalPageCount();
		//控制首页
		if (currentNo<1) {
			currentNo=1;
		}else if (currentNo>=totalPageCount) 
		{
			//控制末页显示
			currentNo=totalPageCount;
		}
		//根据id currentNo pageSize的值查询对应的商品集合
		List<EasybuyProduct> productList = ebps.findEasybuyProdouctsById(categoryLevelId, currentNo, pageSize);
		//保存当前页码用来进行分页查询
		req.setAttribute("currentNo", currentNo);
		log.debug("商品总页数"+totalPageCount);
		//保存总页数用来进行翻页查询
		req.setAttribute("totalPageCount", totalPageCount);
		//把查询到的商品集合放到request请求里面传到商品列表页面
		req.setAttribute("productShow", productList);
		//保存总条数
		req.setAttribute("count", count);
		//保存总页数
		req.setAttribute("totalPageCount", totalPageCount);
		//转发到产品列表页
		req.getRequestDispatcher("productList.jsp").forward(req, resp);
	
	}
}
