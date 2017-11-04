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
		//获取请求值
		String pid = req.getParameter("id");
		int id=Integer.parseInt(pid);
		//创建对象
		EasybuyProduct ebp=new EasybuyProduct();					//商品对象
		EasybuyProductService ebps=new EasybuyProductServiceImpl();	//商品业务对象
		HttpSession session = req.getSession();						
		//获取session中cars购物车是否有值
		Object map = session.getAttribute("cars");
		//声明一个Map集合，用于存储购物车商品，key为商品ID，value为商品对象
		Map<Integer, EasybuyProduct> Pmap=new HashMap<Integer, EasybuyProduct>();
		
		//如果map为空
		if (map==null) {
			//获取指定商品
			ebp=ebps.findProductById(id);
			//设置该商品在购物车的数量
			ebp.setNum(1);
			//把商品存放入购物车中
			Pmap.put(id, ebp);
			//把map存储在session中
			session.setAttribute("cars", Pmap);
			
		}else if(map!=null){
			//如果map部不为空
			//获取map
			Pmap=(Map<Integer, EasybuyProduct >)map;
			//获取Pmap里面的keys
			Set<Integer> keySet = Pmap.keySet();
			
			boolean isFind = false; //如果map找到指定的key值，返回true，否则返回false
			//遍历key值
			for (Integer kid : keySet) {
				//判断如果key值与id相等 则对应的Product 中的num+1
				if (id==kid) {
					/*EasybuyProduct ebp1	=ebps.findProductById(id);
					int num=ebp1.getNum();
					num++;
					ebp1.setNum(num);
					Pmap.put(kid, ebp1);
					session.setAttribute("keyId", Pmap);*/
					//把该key的对象的num值加1
					Pmap.get(kid).setNum(Pmap.get(kid).getNum()+1);
					session.setAttribute("cars", Pmap);
					isFind = true;
				}
				/*else{
					//判断如果key值与id不相等 则对应的Product 中的num+1
					EasybuyProduct ebp1	=ebps.findProductById(id);
					ebp1.setNum(1);
					Pmap.put(id, ebp1);
					session.setAttribute("cars", Pmap);
				}*/
			}
			
			if(!isFind){
				//如果map找不到指定的key值，获取新的商品对象
				EasybuyProduct ebp1	=ebps.findProductById(id);
				//设置商品在购物车的数量
				ebp1.setNum(1);
				//添加到map中
				Pmap.put(id, ebp1);
				//保存到session中
				session.setAttribute("cars", Pmap);
			}
			
			
			
			
		}
		
		
		double totalCost = 0; //所有商品的价格
		
		Set<Integer> keySet = Pmap.keySet();
		for (Integer key : keySet) {
			EasybuyProduct easybuyProduct = Pmap.get(key);
			totalCost +=easybuyProduct.getNum() * easybuyProduct.getPrice();
		}
		//把所有商品的总价格存储到session当中
		session.setAttribute("totalCost", totalCost);
		//跳转页面
		resp.sendRedirect("Page_Car.jsp");
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
