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

@WebServlet(urlPatterns="/product_servlet",name="prosuct_servlet")
public class Product_servlet extends HttpServlet {
	private static Logger log=Logger.getLogger(Product_servlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String product = req.getParameter("type");
		if (product!=null) {
			if (product.equals("Product")) {
				EasybuyProductService ebpt=new EasybuyProductServiceImpl();
				int pageSize=10;
				//商品总体条数
				int total = ebpt.findProductTotal();
				//当前页
				int currentNo=Integer.parseInt(req.getParameter("currentNo"));
				req.setAttribute("currentNo", currentNo);
				List<EasybuyProduct> ProductList = ebpt.findProductList(currentNo, pageSize);
				req.setAttribute("ProductList", ProductList);
				Page page=new Page();
				page.setCurrentNo(currentNo);
				log.debug(total);
				page.setPageSize(pageSize);
				page.setCount(total);
				page.setProductList(ProductList);
				//获取总页数
				int pageTotal=page.getTotalPageCount();
				req.setAttribute("pageTotal", pageTotal);
				log.debug("总页数："+pageTotal);
				req.getRequestDispatcher("Page_product.jsp").forward(req, resp);
			}
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
