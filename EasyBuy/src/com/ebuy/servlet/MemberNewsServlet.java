package com.ebuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyNewsService;
import com.ebuy.service.EasybuyUserService;
import com.ebuy.service.impl.EasybuyNewsServiceImpl;
import com.ebuy.service.impl.EasybuyUserServiceImpl;
/**
 * 
 * @author linbingyang
 * @version 1.0 2017-11-3
 * 后台新闻列表控制器
 *
 */
public class MemberNewsServlet extends HttpServlet {
	private Logger log = Logger.getLogger(MemberNewsServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//获取请求类型
		String type = req.getParameter("type");
		
		//判断请求类型
		if(type != null){
			if(type.equals("newsList")){
				//请求类型为：获取用户列表
				log.debug(">>>>>>>>获取咨询列表");
				//获取请求参数
				int currentNo = Integer.parseInt(req.getParameter("currentNo"));   //获取当前页
				//创建用户业务对象
				EasybuyNewsService newsService = new EasybuyNewsServiceImpl();
				//获取当前页所需的用户对象集合
				
				//存储转发值
				req.setAttribute("currentNo", page.getCurrentNo());
				req.setAttribute("totalPageCount", page.getTotalPageCount());
				req.setAttribute("userList", page.getPageList());
				//转发请求
				req.getRequestDispatcher("Page_userList.jsp").forward(req, resp);
			}
		}
	}
}
