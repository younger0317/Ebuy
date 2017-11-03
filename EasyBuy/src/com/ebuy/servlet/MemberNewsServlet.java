package com.ebuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ebuy.entity.EasybuyNews;
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
 * 后台资讯列表控制器
 *
 */
@WebServlet(urlPatterns={"/MemberNews"},name = "MemberNews")
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
				//请求类型为：获取资讯列表
				log.debug(">>>>>>>>获取资讯列表");
				//获取请求参数
				int currentNo = Integer.parseInt(req.getParameter("currentNo"));   //获取当前页
				//创建用户业务对象
				EasybuyNewsService newsService = new EasybuyNewsServiceImpl();
				//获取当前页所需的资讯对象集合
				Page<EasybuyNews> page = newsService.findPageList(currentNo, 10);
				//存储转发值
				req.setAttribute("currentNo", page.getCurrentNo());
				req.setAttribute("totalPageCount", page.getTotalPageCount());
				req.setAttribute("newsList", page.getPageList());
				//转发请求
				req.getRequestDispatcher("Page_newsList.jsp").forward(req, resp);
			}else if(type.equals("showInfo")){
				//请求类型为：资讯详情展示
				log.debug(">>>>>>>>资讯详情展示");
				//获取请求参数
				int id  = Integer.parseInt(req.getParameter("id"));
				//创建用户业务对象
				EasybuyNewsService newsService = new EasybuyNewsServiceImpl();
				//获取资讯对象
				EasybuyNews news = newsService.findNewsById(id);
				//存储资讯对象
				req.setAttribute("news", news);
				//转发
				req.getRequestDispatcher("Page_newsInfo.jsp").forward(req, resp);
				
			}
		}
	}
}
