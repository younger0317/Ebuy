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
		EasybuyOrderService eos=new EasybuyOrderServiceImpl();
		EasybuyOrderDetailService eods=new EasybuyOrderDetailServiceImpl();
		List<EasybuyOrder> eoList = eos.findEasybuyOrdersList();
		Map<String, List<EasybuyOrderDetail>> map=new HashMap<String, List<EasybuyOrderDetail>>();
		for (EasybuyOrder easybuyOrder : eoList) {
			Integer id = easybuyOrder.getId();
			List<EasybuyOrderDetail> eodList = eods.findEasybuyOrderDetailList(id);
			map.put(id.toString(),eodList);
		}
	}
}
