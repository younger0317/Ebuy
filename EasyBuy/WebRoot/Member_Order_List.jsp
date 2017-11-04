<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table>	
				<c:forEach items="${eoList}" var="eo" varStatus="status" >
		    		<tr>
		    			<th>用户名：${eo.loginName}</th>
		    			<th>订单号：${eo.serialNumber}</th>
		    			<th>地址：${eo.userAddress}</th>
		    			<th>￥${eo.cost}</th>
		    		</tr>				
		    		<tr>
			    		<td>商品名称</td>
			    		<td>商品图片</td>
			    		<td>数量</td>
			    		<td>价格</td>
		    		</tr>
		    		<c:set  var="key" value="${eo.id}${''}"></c:set>
		    		<c:forEach items="${map[key]}" var="eod" varStatus="status">
				    		<tr>
					    		<td>${eod.id}</td>
					    		<td>null</td>
					    		<td>${eod.quantity}</td>
					    		<td>${eod.cost}</td>
				    		</tr>
		    		</c:forEach>
				</c:forEach>
		    	</table>
  </body>

