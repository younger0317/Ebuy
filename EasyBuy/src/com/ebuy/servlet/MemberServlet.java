package com.ebuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyUserService;
import com.ebuy.service.impl.EasybuyUserServiceImpl;

/**
 * 
 * @author linbingyang
 * @version 1.0 2017-10-31
 * 后台控制器
 *
 */
@WebServlet(urlPatterns={"/MemberServlet"},name = "MemberServlet")
public class MemberServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		//获取请求类型
		String type = req.getParameter("type");
		//判断请求类型
		if(type != null){
			if(type.equals("userList")){
				//请求类型为：获取用户列表
				//获取请求参数
				int currentNo = Integer.parseInt(req.getParameter("currentNo"));
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				//获取所需的用户对象集合
				Page<EasybuyUser> page = userService.findPageList(currentNo, 10);
				req.setAttribute("currentNo", page.getCurrentNo());
				req.setAttribute("totalPageCount", page.getTotalPageCount());
				req.setAttribute("userList", page.getPageList());
				req.getRequestDispatcher("Page_userList.jsp").forward(req, resp);
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
