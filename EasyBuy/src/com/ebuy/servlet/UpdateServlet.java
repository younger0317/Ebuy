package com.ebuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ebuy.entity.EasybuyProduct;
import com.ebuy.service.EasybuyProductCategoryService;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.service.impl.EasybuyProductCategoryServiceImpl;
import com.ebuy.service.impl.EasybuyProductServiceImpl;
@WebServlet(urlPatterns="/UpdateServlet",name="UpdateServlet")
public class UpdateServlet extends HttpServlet{

	private static Logger log=Logger.getLogger(AddProductServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		int id=Integer.parseInt(req.getParameter("id"));
		//创建分类查询对象
		EasybuyProductCategoryService epcs=new EasybuyProductCategoryServiceImpl();
		//获取表单提交的参数值
		String name1=req.getParameter("first");
		String name2=req.getParameter("second");
		String name3=req.getParameter("third");
		Float price=Float.parseFloat(req.getParameter("price"));
		int stock=Integer.parseInt(req.getParameter("number"));
		String fileName=req.getParameter("img");
		String description=req.getParameter("dic");
		String name=req.getParameter("product");
		//查询1. 2. 3级id
		int categoryLevel1Id=epcs.findIdByName(name1);
		int categoryLevel2Id=epcs.findIdByName(name2);
		int categoryLevel3Id=epcs.findIdByName(name3);
		//创建商品类对象并封装数据
		EasybuyProduct ebp=new EasybuyProduct();
		ebp.setCategoryLevel1Id(categoryLevel1Id);
		ebp.setCategoryLevel2Id(categoryLevel2Id);
		ebp.setCategoryLevel3Id(categoryLevel3Id);
		ebp.setDescription(description);
		ebp.setFileName(fileName);
		ebp.setName(name);
		ebp.setPrice(price);
		ebp.setStock(stock);
		ebp.setId(id);
		//创建商品业务类对象 
		EasybuyProductService eps=new EasybuyProductServiceImpl();
		//更新商品
		eps.updatProduct(ebp);
		log.debug("更新数据成功");
		String flag="update";
		req.setAttribute("flag", flag);
		req.getRequestDispatcher("Member.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
