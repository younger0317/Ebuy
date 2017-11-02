package com.ebuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebuy.entity.EasybuyProduct;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.service.impl.EasybuyProductServiceImpl;

@WebServlet(urlPatterns="/product_servlet",name="prosuct_servlet")
public class Product_servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String product = req.getParameter("type");
		if (product!=null) {
			if (product.equals("Product")) {
				EasybuyProductService ebpt=new EasybuyProductServiceImpl();
				int pageSize=5;
				//商品总体条数
				int total = ebpt.findProductTotal();
				//当前页
				int currentNo=Integer.parseInt(req.getParameter("currentNo"));
				List<EasybuyProduct> ProductList = ebpt.findProductList(currentNo, pageSize);
				Page page=new Page();
				page.setCurrentNo(currentNo);
				page.setTotalCount(total);
				page.setPageSize(pageSize);
				page.setPageList(ProductList);
				//总页数
				int pageTotal=page.getTotalPageCount();
				
				
			}
			
		}
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
