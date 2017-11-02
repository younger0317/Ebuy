<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<p></p>
<div class="mem_tit">用户列表</div>
<table id="UserList" border="1" cellspacing="0" align="center">
	<tr align="center" height="30">
		<td width="150px">用户名称</td>
		<td width="150px">真实姓名</td>
		<td width="150px">性别</td>
		<td width="150px">类型</td>
		<td colspan="2" width="200px">操作</td>
	</tr>
	<c:forEach items="${requestScope.userList}" var="user" varStatus="status">
		<tr align="center" height="30">
			<td width="150px">${user.loginName }</td>
			<td width="150px">${user.userName }</td>
			<c:choose>
				<c:when test="${user.sex == 0 }">
					<td width="150px">女</td>
				</c:when>
				<c:otherwise>
					<td width="150px">男</td>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${user.type == 0 }">
					<td width="150px">用户</td>
				</c:when>
				<c:otherwise>
					<td width="150px">管理员</td>
				</c:otherwise>
			</c:choose>
			<td><a href="">修改</a>
			</td>
			<td><a href="">删除</a>
			</td>	
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

