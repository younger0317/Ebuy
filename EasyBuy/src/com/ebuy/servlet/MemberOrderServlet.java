package com.ebuy.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebuy.entity.EasybuyOrder;
import com.ebuy.entity.EasybuyOrderDetail;
import com.ebuy.service.EasybuyOrderDetailService;
import com.ebuy.service.EasybuyOrderService;
import com.ebuy.service.impl.EasybuyOrderDetailServiceImpl;
import com.ebuy.service.impl.EasybuyOrderServiceImpl;

@WebServlet(urlPatterns={"/MemberOrderServlet"},name = "MemberOrderServlet")
public class MemberOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		EasybuyOrderService Order = new EasybuyOrderServiceImpl();
		List<EasybuyOrder> OrdersList = Order.findEasybuyOrdersList();
		req.setAttribute("OrdersList", OrdersList);
		req.setCharacterEncoding("utf-8");
		req.getRequestDispatcher("Member_Order_List.jsp").forward(req, resp);
	}
}
