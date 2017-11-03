package com.ebuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
	private Logger log = Logger.getLogger(MemberServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		//获取请求类型
		String type = req.getParameter("type");
		//判断请求类型
		if(type != null){
			if(type.equals("userList")){
				//请求类型为：获取用户列表
				log.debug(">>>>>>>>获取用户列表");
				//获取请求参数
				int currentNo = Integer.parseInt(req.getParameter("currentNo"));   //获取当前页
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				//获取当前页所需的用户对象集合
				Page<EasybuyUser> page = userService.findPageList(currentNo, 10);
				//存储转发值
				req.setAttribute("currentNo", page.getCurrentNo());
				req.setAttribute("totalPageCount", page.getTotalPageCount());
				req.setAttribute("userList", page.getPageList());
				//转发请求
				req.getRequestDispatcher("Page_userList.jsp").forward(req, resp);
			}else if(type.equals("modify")){
				//请求类型：修改页面跳转请求
				log.debug(">>>>>>>>修改页面跳转请求");
				//获取请求参数
				int id = Integer.parseInt(req.getParameter("id"));
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				//获取指定用户对象
				EasybuyUser user = userService.findUserById(id);
				//存储转发值
				req.setAttribute("user", user);
				//转发请求
				req.getRequestDispatcher("Page_userModify.jsp").forward(req, resp);
				
			}else if(type.equals("doModify")){
				//请求类型：修改请求
				log.debug(">>>>>>>>修改请求");
				//获取请求参数
				int id = Integer.parseInt(req.getParameter("id"));
				String loginName = req.getParameter("loginName");
				String userName = req.getParameter("userName");
				String identityCode = req.getParameter("identityCode");
				String email = req.getParameter("email");
				String mobile = req.getParameter("mobile");
				int userType = Integer.parseInt(req.getParameter("userType"));
				
				//System.out.println(id+" "+loginName+" "+userName+" "+identityCode+" "+email+" "+mobile+" "+userType);
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				//创建新的用户对象，用于存储修改的用户信息
				EasybuyUser user = new EasybuyUser();
				//存储user的值
				user.setId(id);
				user.setLoginName(loginName);
				user.setUserName(userName);
				user.setIdentityCode(identityCode);
				user.setEmail(email);
				user.setMobile(mobile);
				user.setType(userType);
				//更新用户信息
				boolean modifyUser = userService.modifyUser(user);
				if(modifyUser){
					//更新成功
					log.debug("更新成功");
					resp.sendRedirect("Member_UserList.jsp");	
				}else{
					//更新失败
					log.debug("更新失败");
					EasybuyUser user2 = userService.findUserById(id);
					req.getRequestDispatcher("Page_userModify.jsp").forward(req, resp);
				}	
			}else if(type.equals("checkName")){
				//请求类型：用户名是否存在请求
				log.debug(">>>>>>>>用户名是否存在请求");
				//获取请求参数
				String loginName = req.getParameter("loginName");
				
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				//判断用户名是否存在
				if(userService.findUserByLoginName(loginName)){
					//用户名存在
					log.debug(">>>>>>>>用户登陆名存在");
					out.print("true");
				}else{
					//用户名不存在
					log.debug(">>>>>>>>用户登陆名不存在");
					out.print("false");
				}
				out.flush();
				out.close();
			}else if(type.equals("del")){
				//请求类型：删除用户
				log.debug(">>>>>>>>删除用户");
				//获取请求参数
				int id = Integer.parseInt(req.getParameter("id"));
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				//删除操作
				boolean del = userService.delUserById(id);
				if(del){
					out.print("true");
				}else{
					out.print("false");
				}
				out.flush();
				out.close();
			}else if(type.equals("add")){
				//请求类型：添加页面跳转
				log.debug(">>>>>>>>页面跳转");
				//页面跳转
				req.getRequestDispatcher("Page_userAdd.jsp").forward(req, resp);
				
			}else if(type.equals("doAdd")){
				//请求类型：添加用户
				log.debug(">>>>>>>>添加用户");
				//获取请求参数
				String loginName = req.getParameter("loginName");
				String userName = req.getParameter("userName");
				String identityCode = req.getParameter("identityCode");
				String email = req.getParameter("email");
				String mobile = req.getParameter("mobile");
				int userType = Integer.parseInt(req.getParameter("userType"));
				int sex = Integer.parseInt(req.getParameter("sex"));
				String password = req.getParameter("password");
				//创建用户业务对象
				EasybuyUserService userService = new EasybuyUserServiceImpl();
				
				//创建新的用户对象，用于存储修改的用户信息
				EasybuyUser user = new EasybuyUser();
				//存储user的值
				user.setLoginName(loginName);
				user.setUserName(userName);
				user.setIdentityCode(identityCode);
				user.setEmail(email);
				user.setMobile(mobile);
				user.setType(userType);
				user.setSex(sex);
				user.setPassword(password);
				
				
				//添加操作
				boolean add = userService.addUser(user);
				if(add){
					log.debug(">>>>>>>>>>添加成功");
					out.print("true");
				}else{
					log.debug(">>>>>>>>>>添加失败");
					out.print("false");
				}
				
				out.flush();
				out.close();

			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
