package com.ebuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ebuy.service.EasybuyProductService;
import com.ebuy.service.impl.EasybuyProductServiceImpl;
@WebServlet(urlPatterns="/DelServlet",name="DelServlet")
public class DelServlet extends HttpServlet{
	private static Logger log=Logger.getLogger(AddProductServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String num=req.getParameter("id");
		int id=Integer.parseInt(num);
		//创建商品业务类对象 
		EasybuyProductService eps=new EasybuyProductServiceImpl();
		eps.delProduct(id);
		log.debug("删除成功");
		String flag="del";
		req.setAttribute("flag", flag);
		req.getRequestDispatcher("Member.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
