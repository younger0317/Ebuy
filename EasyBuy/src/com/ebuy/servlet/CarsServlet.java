package com.ebuy.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebuy.entity.EasybuyProduct;
import com.ebuy.service.EasybuyProductService;
import com.ebuy.service.impl.EasybuyProductServiceImpl;
@WebServlet(urlPatterns="/CarsServlet",name="CarsServlet")
public class CarsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String pid = req.getParameter("id");
		int id=Integer.parseInt(pid);
		EasybuyProduct ebp=new EasybuyProduct();
		EasybuyProductService ebps=new EasybuyProductServiceImpl();
		HttpSession session = req.getSession();
		Object map = session.getAttribute("keyId");
		
		Map<Integer, EasybuyProduct> Pmap=new HashMap<Integer, EasybuyProduct>();
		if (map==null) {
			ebp=ebps.findProductById(id);
			ebp.setNum(1);
			Pmap.put(id, ebp);
			session.setAttribute("keyId", Pmap);
			
		}else if(map!=null){
			Pmap=(Map<Integer, EasybuyProduct >)map;
			//获取Pmap里面的keys
			Set<Integer> keySet = Pmap.keySet();
			//遍历key值
			for (Integer kid : keySet) {
				//判断如果key值与id相等 则对应的Product 中的num+1
				if (id==kid) {
					EasybuyProduct ebp1	=ebps.findProductById(id);
					int num=ebp1.getNum();
					num++;
					ebp1.setNum(num);
					/*Pmap.put(kid, ebp1);
					session.setAttribute("keyId", Pmap);*/
				}else{
					//判断如果key值与id不相等 则对应的Product 中的num+1
					EasybuyProduct ebp1	=ebps.findProductById(id);
					ebp1.setNum(1);
					Pmap.put(id, ebp1);
					session.setAttribute("keyId", Pmap);
				}
			}
			
			
			
		}
		//跳转页面
		resp.sendRedirect("Page_Car.jsp");
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
