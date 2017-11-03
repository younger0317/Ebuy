<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<p></p>
<div class="mem_tit">用户列表</div>
<input type="button" value="添加资讯" onclick="toAddPage()"/>
<table id="UserList" border="1" cellspacing="0" align="center">
	<tr align="center" height="30">
		<td width="350px">文章标题</td>
		<td width="350px">创建时间</td>
	</tr>
	<c:forEach items="${requestScope.newsList }" var="news" varStatus="status">
		<tr align="center" height="30">
			<td><a href="javascript:var id=${news.id };toShowInfo(id)">${news.title }</a></td>
			<td>${news.createTime }</td>
		</tr>
	</c:forEach>
	
</table>
<div align="center" style="font-size: 18px;margin-top: 10px;">
	<a href="javascript:currentNo=1;redirect(currentNo)">首页</a> 
	<c:if test="${requestScope.currentNo >1}">
		<a href="javascript:currentNo=${requestScope.currentNo-1};redirect(currentNo)">上一页</a> 
	</c:if>
	<a href="javascript:currentNo=${requestScope.currentNo};redirect(currentNo)">${requestScope.currentNo}</a> 
	<c:if test="${requestScope.currentNo != requestScope.totalPageCount}">
		<a href="javascript:currentNo=${requestScope.currentNo+1};redirect(currentNo)">${requestScope.currentNo+1}</a>
	</c:if>
	<c:if test="${requestScope.currentNo<requestScope.totalPageCount}">
		<a href="javascript:currentNo=${requestScope.currentNo+1};redirect(currentNo)">下一页</a> 
	</c:if>
	<a href="javascript:currentNo=${requestScope.totalPageCount};redirect(currentNo)">尾页</a>
</div>