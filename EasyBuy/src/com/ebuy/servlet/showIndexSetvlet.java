package com.ebuy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.service.EasybuyProductCategoryService;
import com.ebuy.service.impl.EasybuyProductCategoryServiceImpl;
/**
 *	首次显示首页所有数据，控制页
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={"/showIndex"},name = "showIndex")
public class showIndexSetvlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EasybuyProductCategoryService epcs=new 	EasybuyProductCategoryServiceImpl();
		List<EasybuyProductCategory> type1IbAll = epcs.findType1IbAll();
		List<Integer> listtypeid=new ArrayList<Integer>();
		for (EasybuyProductCategory integer : type1IbAll) {
			Integer id = integer.getId();
			listtypeid.add(id);
		}
		List<EasybuyProductCategory> type2IbAll = epcs.findType2IbAll();
		List<EasybuyProductCategory> type3IbAll = epcs.findType3IbAll();
		System.out.println(type1IbAll.size());
		req.setAttribute("tyep1", type1IbAll);
		req.setAttribute("tyep2", type2IbAll);
		req.setAttribute("tyep3", type3IbAll);
		req.setAttribute("tyepid1", listtypeid);
	
		req.setAttribute("showlist", "showlist");
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
		
		
	}
}
