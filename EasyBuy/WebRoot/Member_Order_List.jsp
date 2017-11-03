<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Member_Order_List.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
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
</html>
