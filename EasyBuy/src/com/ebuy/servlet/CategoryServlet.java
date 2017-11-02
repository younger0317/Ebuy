package com.ebuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebuy.entity.EasybuyProductCategory;
import com.ebuy.entity.EasybuyUser;
import com.ebuy.entity.Page;
import com.ebuy.service.EasybuyProductCategoryService;
import com.ebuy.service.EasybuyUserService;
import com.ebuy.service.impl.EasybuyProductCategoryServiceImpl;
import com.ebuy.service.impl.EasybuyUserServiceImpl;
@WebServlet(urlPatterns={"/CategoryServlet"},name = "CategoryServlet")
public class CategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			if(type.equals("Category")){
				//请求类型为：获取用户列表
				//获取请求参数
				int currentNo = Integer.parseInt(req.getParameter("currentNo"));
				//创建分类对象
				EasybuyProductCategoryService epcs=new EasybuyProductCategoryServiceImpl();
				
				//获取所需的用户对象集合
				Page<EasybuyProductCategory> page = epcs.getCategotyAll(currentNo, 10);
				req.setAttribute("currentNo", page.getCurrentNo());
				req.setAttribute("totalPageCount", page.getTotalPageCount());
				req.setAttribute("userList", page.getPageList());
				req.getRequestDispatcher("Page_Category.jsp").forward(req, resp);
			}else if(type.equals("delete")){
				EasybuyProductCategoryService epcs=new EasybuyProductCategoryServiceImpl();
				String string = req.getParameter("categoryid");
				int count = epcs.deleteCategoty(Integer.parseInt(string));
				if(count==0){
					
					out.print("<script type='text/javascript'>");
					out.print("alert('分类下有分类不能删除');");
					out.print("location.href='Member_Category.jsp';");
					out.print("</script>");
					
				}else{
					out.print("<script type='text/javascript'>");
					out.print("alert('删除成功');");
					out.print("location.href='Member_Category.jsp'");
					out.print("</script>");
				}
				//resp.sendRedirect("Member_Category.jsp");
				
			}
		}
		
	}
}
