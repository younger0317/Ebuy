<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<p></p>
<div class="mem_tit">商品列表</div>
<table id="UserList" border="1" cellspacing="0" align="center">
	<tr align="center" height="30">
		<td width="150px">商品名称</td>
		<td width="150px">商品图片</td>
		<td width="150px">库存</td>
		<td width="150px">价格</td>
		<td colspan="2" width="200px">操作</td>
	</tr>
	<c:forEach items="${requestScope.ProductList}" var="product" varStatus="status">
		<tr align="center" height="30">
		<td width="150px">${product.name }</td>
		<td width="150px">${product.fileName }</td>
		<td width="150px">${product.stock }</td>
		<td width="150px">${product.price }</td>
		<td><a href="Member_UpdateProduct.jsp?id=${product.id}">修改</a>
		</td>
		<td><a href="DelServlet?id=${product.id}">删除</a>
		</td>	
	</c:forEach>
	</tr>
</table>
<div align="center" style="font-size: 18px;margin-top: 10px;">

	<a href="javascript:currentNo=1;redirect(currentNo)">首页</a> 
	<c:if test="${requestScope.currentNo >1}">
		<a href="javascript:currentNo=${requestScope.currentNo-1};redirect(currentNo)">上一页</a> 
	</c:if>
	<a href="javascript:currentNo=${requestScope.currentNo};redirect(currentNo)">${requestScope.currentNo}</a> 
	<c:if test="${requestScope.currentNo != requestScope.pageTotal}">
		<a href="javascript:currentNo=${requestScope.currentNo+1};redirect(currentNo)">${requestScope.currentNo+1}</a>
	</c:if>
	<c:if test="${requestScope.currentNo<requestScope.pageTotal}">
		<a href="javascript:currentNo=${requestScope.currentNo+1};redirect(currentNo)">下一页</a> 
	</c:if>
	<a href="javascript:currentNo=${requestScope.pageTotal};redirect(currentNo)">尾页</a>
	<%-- <a href="product_servlet?currentNo=1">首页</a>
	<a href="product_servlet?currentNo=${requestScope.currentNo-1}" >上一页</a>
	<a href="product_servlet?currentNo=${requestScope.currentNo+1}">下一页</a>
	<a href="product_servlet?currentNo=${requestScope.pageTotal}">尾页</a> --%>
</div>
</div>
