<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table>	
				<c:forEach items="${OrdersList}" var="Orders" varStatus="status" >
		    		<tr>
		    			<th>用户名：${Orders.loginName}</th>
		    			<th>订单号：${Orders.serialNumber}</th>
		    			<th>地址：${Orders.userAddress}</th>
		    			<th>￥${Orders.cost}</th>
		    		</tr>				
		    		<tr>
			    		<td>商品名称</td>
			    		<td>商品图片</td>
			    		<td>数量</td>
			    		<td>价格</td>
		    		</tr>
		    		<c:forEach items="${Orders.easybuyOrderDetail}" var="OrderDetail" varStatus="status">
					    <tr>
						    <td>${OrderDetail.products.name}</td>
						    <td>null</td>
						    <td>${OrderDetail.quantity}</td>
						    <td>${OrderDetail.cost}</td>
					    </tr>
				    </c:forEach>
				</c:forEach>
		    	</table>
  </body>

